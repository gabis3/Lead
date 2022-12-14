package br.com.qualifylead.lead.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.qualifylead.lead.Util.PaginacaoUtil;
import br.com.qualifylead.lead.domain.TbLead;
import br.com.qualifylead.lead.domain.UF;
import br.com.qualifylead.lead.service.LeadService;

@Controller
@RequestMapping("/lead")
public class LeadController {
	@Autowired
	private LeadService service;
	
	 @GetMapping({"/cadastrar"})
	    public ModelAndView cadastroLead() {
	        ModelAndView modelAndView = new ModelAndView("lead/cadastro");
	        modelAndView.addObject("lead", new TbLead());

	        return modelAndView;
	    }
	 
	@GetMapping("/listar")
	public String listarLead(ModelMap model, @RequestParam("page") Optional<Integer> page,  @RequestParam("dir") Optional<String> dir) {
		
		int paginaAtual = page.orElse(1);
		String ordem = dir.orElse("asc");
		
		PaginacaoUtil<TbLead> pageLead = service.buscaPorPagina(paginaAtual, ordem);
		
		model.addAttribute("pageLead", pageLead);
		return "/lead/listaLead";
	}
	
	@PostMapping("/salvar")
	public String salvar(TbLead lead, RedirectAttributes attr) {
		String contato = lead.getCelLead();
		List<TbLead> ret = service.buscarPorContato(contato);
		if (ret.size() != 0) {
			attr.addFlashAttribute("fail", "Lead já existe no cadastro de Leads.");
		}else {
			
			service.salvar(lead);
		
			attr.addFlashAttribute("success", "Lead inserido com sucesso.");
		}
		return "redirect:/lead/cadastrar";
	}
//
// Edita o cadastro com id selecionado 
//
	@GetMapping("/{id}/editar")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("lead", service.buscarPorID(id));
		return "/lead/cadastro";
	}
//
// Editar = update - ok 
//	
	@PostMapping("/editar")
	public String editar(TbLead lead, RedirectAttributes attr) {
		service.editar(lead);
		
		attr.addFlashAttribute("success", "Lead editado com sucesso." );
		return "redirect:/lead/listar"; 
	}
	
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView =  new ModelAndView("redirect:/lead/listar");
		service.excluir(id);
		return modelAndView;
	}
	
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("lead", service.buscarPorNome(nome));
		
		return "/lead/pesquisarLead";
	}
	@GetMapping("/buscar/contato")
	public String getPorContato(@RequestParam("contato") String contato, ModelMap model) {
		model.addAttribute("lead", service.buscarPorContato(contato));
		
		return "/lead/pesquisarLead";
	}
	@GetMapping("/buscar/status")
	public String getPorStatus(@RequestParam("situacao") String situacao, ModelMap model) {
		model.addAttribute("lead", service.buscarPorSituacao(situacao));
		
		return "/lead/pesquisarLead";
	}
	
}
