package application.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.models.Plataforma;
import application.repositories.PlataformaRepository;

@Controller
@RequestMapping("/plataformas")
public class PlataformaController {
    @Autowired
    private PlataformaRepository plataformaRepo;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("plataformas", plataformaRepo.findAll());
        return "list.jsp"; 
    }

    @RequestMapping("insert")
    public String formInsert() {
        return "insert.jsp";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String saveInsert(@RequestParam("nome") String nome) {
        Plataforma plataforma = new Plataforma();
        plataforma.setNome(nome);

        plataformaRepo.save(plataforma);

        return "redirect:/plataformas/list";
    }

    @RequestMapping("update/{id}")
    public String formUpdate(Model model, @PathVariable int id) {
        Optional<Plataforma> plataforma = plataformaRepo.findById(id);
        if(!plataforma.isPresent())
            return "redirect:/plataformas/list";
        model.addAttribute("plataforma", plataforma.get());
        return "/plataformas/update.jsp";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String saveUpdate(@RequestParam("nome") String nome, @RequestParam("id") int id) {
        Optional<Plataforma> plataforma = plataformaRepo.findById(id);
        if(!plataforma.isPresent())
            return "redirect:/plataformas/list";
        plataforma.get().setNome(nome);

        plataformaRepo.save(plataforma.get());

        return "redirect:/plataformas/list";
    }

    @RequestMapping("delete/{id}")
    public String formDelete(Model model, @PathVariable int id) {
        Optional<Plataforma> plataforma = plataformaRepo.findById(id);
        if(!plataforma.isPresent())
            return "redirect:/plataformas/list";
        model.addAttribute("plataforma", plataforma.get());
        return "/plataformas/delete.jsp";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String confirmDelete(@RequestParam("id") int id) {
        plataformaRepo.deleteById(id);
        return "redirect:/plataformas/list";
    }
}