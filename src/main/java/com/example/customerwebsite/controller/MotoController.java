package com.example.customerwebsite.controller;

        import com.example.customerwebsite.model.Customer;
        import com.example.customerwebsite.model.RentalMoto;
        import com.example.customerwebsite.services.CustomerService;
        import com.example.customerwebsite.services.MotoService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@Controller
public class MotoController {

    @Autowired
    MotoService motoService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/moto")
    public String viewHomePage(Model model) {
        final List<RentalMoto> motoList = motoService.getMoto();
        model.addAttribute("motoList", motoList);
        return "moto";
    }

    @GetMapping("/new-moto")
    public String showNewMotoPage(Model model) {
        RentalMoto moto = new RentalMoto();
        model.addAttribute("moto", moto);
        return "new-moto";
    }

    @PostMapping("/moto")
    public String saveMoto(@ModelAttribute("moto") RentalMoto moto, Model model) {
        try {
            motoService.saveMoto(moto);
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", "Could not save moto, " + e.getMessage());
            return "error-page";
        }
        return "redirect:/moto";
    }

    @RequestMapping("/moto/remove/{id}")
    public String removeMoto(@PathVariable(name = "id") Long motoId) {
        RentalMoto moto = motoService.getMoto(motoId);
        moto.setCustomer(null);
        motoService.saveMoto(moto);
        return "redirect:/";
    }

    @GetMapping("/moto/assign/{id}")
    public String assignMoto(@PathVariable(name = "id") Long id, Model model) {
        Customer customer = customerService.getCustomer(id);
        List<RentalMoto> motoList = motoService.getAvailableMoto();
        model.addAttribute("customer", customer);
        model.addAttribute("motoList", motoList);
        return "assign-moto";
    }

    @PostMapping("/moto/assign")
    public String saveMotoAssignment(@RequestParam("customerId") Long customerId, @RequestParam("motoId") Long motoId) {
        RentalMoto moto = motoService.getMoto(motoId);
        moto.setCustomer(customerService.getCustomer(customerId));
        motoService.saveMoto(moto);
        return "redirect:/";
    }
}