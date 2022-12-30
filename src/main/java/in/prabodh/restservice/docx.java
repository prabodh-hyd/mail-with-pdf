package in.prabodh.restservice;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class docx {

    private File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {

            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());

            return new File(resource.toURI());
        }

    }
    public void findAndUpdateImage(Document doc,Employee emp1) throws IOException {

        ArrayList<String> imgNames=new ArrayList<>();

        Elements img = doc.getElementsByTag("img");
        for (Element el : img) {
            String srcValue = el.attr("src");
            System.out.println("Image Found!");
            System.out.println("src attribute is : "+srcValue);
            if(Objects.equals(emp1.getEmpName(), "Raama")) {

                srcValue = srcValue.replace("emp2", "emp1");
            }else if(Objects.equals(emp1.getEmpName(), "Sitha")){
                srcValue = srcValue.replace("emp1", "emp2");
            }
            System.out.println("changed src attribute is : "+srcValue);
            el.attr("src", srcValue);

    }


    }
    public void updateVariable(Document doc, Employee emp1){
        Elements els = null; // doc.body().getAllElements();
        els = doc.select("i");
       // Employee emp1=new Employee();
        for(Element e:els){
            switch(e.text()){
                case "emp1" :
                    e.text(emp1.getEmpName());
                    break;
                case "Age":
                    e.text(emp1.getEmpAge());
                    break;
                case "Address":
                    e.text(emp1.getAddress());
                    break;
                case "Date" :
                    e.text(emp1.getDateOfJoining());
                    break;
                case "Experience":
                    e.text(emp1.getExperience());
                    break;
                case "Role":
                    e.text(emp1.getRole());
                    break;
                case "Salary":
                    e.text(emp1.getSalary());
                    break;
                default:
                    System.out.println(e.text());
            }
        }

    }
    private Document getDoc(Employee employee) {
        String inputHTML = "exampleFile.html";


        try {
            File f = getFileFromResource(inputHTML);
            Document document;
            document = Jsoup.parse(f, "UTF-8");

            this.findAndUpdateImage(document,employee);


            this.updateVariable(document,employee);

            document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
            return document;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }



    public String createPDF(Employee employee)  {
        if(employee==null){
            return "employee not found";
        }

        String outputPdf= employee.getOutputPdf();
         Document doc = getDoc(employee);

        try (OutputStream os = new FileOutputStream(outputPdf)) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            String baseUrl = FileSystems.getDefault()
                    .getPath("src/main/resources/")
                    .toUri().toURL().toString();
            builder.withUri(outputPdf);
            builder.toStream(os);
            builder.withW3cDocument(new W3CDom().fromJsoup(doc), baseUrl);
            builder.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return outputPdf;
    }

    public Employee updateEmployee(Employee employee){
       Employee emp=new Employee();
       emp.setEmpName(employee.getEmpName());
       emp.setEmpAge(employee.getEmpAge());
       emp.setAddress(employee.getAddress());
       emp.setDateOfJoining(employee.getDateOfJoining());
       emp.setExperience(employee.getExperience());
       emp.setRole(employee.getRole());
       emp.setSalary(employee.getSalary());
       emp.setOutputPdf(employee.getOutputPdf());

        return emp;
    }
    public void findAndUpdateVariables(Document doc) {


        Elements els = null; // doc.body().getAllElements();
        els = doc.select("i");
        MocTemplateVariables variables = new MocTemplateVariables();
        variables.initValues();
        variables.display();


        for (Element e : els) {
            switch (e.text()) {
                case "loan_app_id":
                    e.text(variables.getLoan_app_id());
                    break;
                case "User_name_variable":
                    e.text(variables.getUser_name_variable());
                    break;

                case "User_address_variable":
                    e.text(variables.getUser_address_variable());
                    break;
                case "registered_mobile_number":
                    e.text(variables.getregistered_mobile_number());

                case "Application_name":
                    e.text(variables.getApplication_name());
                    break;

                case "NBFC_name":
                    e.text(variables.getNBFC_name());
                    break;

                case "tenure":
                    e.text(variables.gettenure());
                    break;

                case "product_name":
                    e.text(variables.getproduct_name());
                    break;

                case "type":
                    e.text(variables.gettype());
                    break;

                case "interest":
                    e.text(variables.getinterest());
                    break;

                case "processing_fee":
                    e.text(variables.getprocessing_fee());
                    break;

                case "state_name":
                    e.text(variables.getstate_name());
                    break;

                default:
                    System.out.println(e.text());
            }
        }
    }



}





