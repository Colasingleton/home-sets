package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 *
 *
 *
 */
@Controller
public class AddPartController {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private PartService partService;
    @Autowired
    private ProductService productService;

    @GetMapping("/showPartFormForUpdate")
    public String showPartFormForUpdate(@RequestParam("partID") int theId,Model theModel){

        PartService repo=context.getBean(PartServiceImpl.class);
        OutsourcedPartService outsourcedrepo=context.getBean(OutsourcedPartServiceImpl.class);
        InhousePartService inhouserepo=context.getBean(InhousePartServiceImpl.class);

        boolean inhouse=true;
        List<OutsourcedPart> outsourcedParts=outsourcedrepo.findAll();
        for(OutsourcedPart outsourcedPart:outsourcedParts) {
            if(outsourcedPart.getId()==theId)inhouse=false;
        }
        String formtype;
        if(inhouse){
            InhousePart inhousePart=inhouserepo.findById(theId);
            theModel.addAttribute("inhousepart",inhousePart);
            formtype="InhousePartForm";
        }
        else{
            OutsourcedPart outsourcedPart=outsourcedrepo.findById(theId);
            theModel.addAttribute("outsourcedpart",outsourcedPart);
            formtype="OutsourcedPartForm";
        }
        return formtype;
    }

    @GetMapping("/deletepart")
    public String deletePart(@Valid @RequestParam("partID") int theId,  Model theModel){
        PartService repo = context.getBean(PartServiceImpl.class);
        Part part=repo.findById(theId);
        if(part.getProducts().isEmpty()){
            repo.deleteById(theId);
            return "confirmationdeletepart";
        }
        else{
            return "negativeerror";
        }
    }

    //cola's block start
    @GetMapping("/buyNow")
    public String buyNow(@RequestParam("partID") int theId,Model theModel) {

        PartService repo = context.getBean(PartServiceImpl.class);
       // OutsourcedPartService outsourcedrepo = context.getBean(OutsourcedPartServiceImpl.class);
       // InhousePartService inhouserepo = context.getBean(InhousePartServiceImpl.class);

        Part part = partService.findById(theId);

        int inv = part.getInv();
        if(inv == 0) {
            return "Failure";
        }
        else {
            return "Success";
        }


    }
    //cola's block end

    }
