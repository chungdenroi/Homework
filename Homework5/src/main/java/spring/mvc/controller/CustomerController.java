package spring.mvc.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvc.model.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class CustomerController {
    private String filename;
    private int i = 0;
    private PrintWriter pw;
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @RequestMapping(value = "/add")
    public String  customer() {
        return "customer";
    }

    protected Customer newCustomer(HttpServletRequest request) {
        String fullname = request.getParameter("fullname");
        LocalDate bod = LocalDate.parse(request.getParameter("birthday"));
        Date birthday = java.sql.Date.valueOf(bod);
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String mobilePhone = request.getParameter("mobilePhone");
        String gender = request.getParameter("gender");
        Customer customer = new Customer(fullname,birthday,email,address,mobilePhone,gender);
        return customer;
    }
    @RequestMapping(value = "/customer")
    public void saveToBin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            filename = "registration.bin";
            FileOutputStream fos = new FileOutputStream(filename,true);
            //save sample data
            if(i == 0) {
                Customer customer1 = sampleCustomer("customer.xml","customer1");
                fos.write((customer1.show()+"\n<br>").getBytes(StandardCharsets.UTF_8));
                ++i;
            }
            //save data from registration form
            Customer customer = newCustomer(request);
            if (!customer.equals(null)) {
                byte b[] = (customer.show()+"\n<br>").getBytes();
                fos.write(b);
                System.out.println("Save to "+ filename +" success!");
                response.setContentType("text/html");
                pw = response.getWriter();
                pw.println("<script>alert('Register success!');window.location='"+request.getContextPath()+"'</script>");
            } else System.out.println("Data is empty!");
            fos.close();
//            response.sendRedirect(request.getContextPath());
        } catch (NullPointerException e) {
            System.out.println("Null");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(value = "/")
    public String readToBin(Model model) throws IOException {
        int stt = 0;
        filename="registration.bin";
        FileInputStream fis1 = new FileInputStream(filename);
        byte s1[] = fis1.readAllBytes();
        String cuss = new String(s1,StandardCharsets.UTF_8);
        model.addAttribute("customer",cuss+"\n");
        return "index";
    }
    protected Customer sampleCustomer(String beanName, String cus) {
        //sample data use bean
        ApplicationContext context = new ClassPathXmlApplicationContext(beanName);
        Customer customer = context.getBean(cus,Customer.class);
        return customer;
    }
}
