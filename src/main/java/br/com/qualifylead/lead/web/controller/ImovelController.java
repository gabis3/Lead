package br.com.qualifylead.lead.web.controller;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.xmlunit.builder.Input;

import br.com.qualifylead.lead.Util.PaginacaoUtil;
import br.com.qualifylead.lead.domain.TbImovel;
import br.com.qualifylead.lead.domain.UF;
import br.com.qualifylead.lead.service.ImovelService;

@Controller
@RequestMapping("/imovel")
public class ImovelController {
	
	@Autowired
	private ImovelService service;
	
	 @GetMapping({"/cadastrar"})
	    public ModelAndView cadastroImovel() {
	        ModelAndView modelAndView = new ModelAndView("imovel/cadastroImovel");
	        modelAndView.addObject("imovel", new TbImovel());

	        
	        return modelAndView;
	    }
	 

	@GetMapping("/listar")
	public String listarImovel(ModelMap model, @RequestParam("page") Optional<Integer> page,  @RequestParam("dir") Optional<String> dir) {
		
		model.addAttribute("imovel", service.buscarTodos());
		int paginaAtual = page.orElse(1);
		String ordem = dir.orElse("asc");
		
		PaginacaoUtil<TbImovel> pageImovel = service.buscaPorPagina(paginaAtual, ordem);
		
		model.addAttribute("pageImovel", pageImovel);
		return "/imovel/listarImoveis";
	}
	
	@PostMapping("/salvar")
	public String salvar(TbImovel imovel, RedirectAttributes attr, Model model) {
        model.addAttribute("input", new TbImovel());
		service.salvar(imovel);
		attr.addFlashAttribute("success", "Imovel inserido com sucesso.");
		return "redirect:/imovel/cadastrar";
	}
	
	 @GetMapping(value = "/currency")
	    public String exchange(
	      @RequestParam(value = "amount") String amount, Locale locale) {
	        return "currencies/currencies";
	    }
//
// Edita o cadastro com id selecionado 
//
	@GetMapping("/{id}/editar")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("imovel", service.buscarPorID(id));
		return "/imovel/cadastroImovel";
	}
//
// Editar = update - ok 
//	
	@PostMapping("/editar")
	public String editar(TbImovel imovel, RedirectAttributes attr) {
		service.editar(imovel);
		attr.addFlashAttribute("success", "Imovel editado com sucesso.");
		return "redirect:/imovel/listar"; 
	}
	
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView =  new ModelAndView("redirect:/imovel/listar");
		service.excluir(id);
		return modelAndView;
	}
	
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
	
	@GetMapping("/buscar/imovel")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("imovel", service.buscarPorDsImovel(nome));
		
		return "/imovel/pesquisarImovel";
	}
	
	@GetMapping("/buscar/tipoImovel")
	public String getPorTipo(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("imovel", service.buscarPorTipoImovel(nome));
		
		return "/imovel/pesquisarImovel";
	}
	
	@GetMapping("/buscar/contato")
	public String getPorContato(@RequestParam("contato") String contato, ModelMap model) {
		model.addAttribute("imovel", service.buscarPorContato(contato));
		
		return "/imovel/pesquisarImovel";
	}
	
	
	@GetMapping("/buscar/proprietario")
	public String getPorProprietario(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("imovel", service.buscarPorProprietario(nome));
		
		return "/imovel/pesquisarImovel";
	}
	
	
	
	@GetMapping("/buscar/status")
	public String getPorStatus(@RequestParam("statusImovel") String status, ModelMap model) {
		model.addAttribute("imovel", service.buscarPorStatus(status));
		
		return "/imovel/pesquisarImovel";
	}
	
	@GetMapping("/buscar/situacao")
	public String getPorSituacao(@RequestParam("situacaoImovel") String situacao, ModelMap model) {
		model.addAttribute("imovel", service.buscarPorSituacao(situacao));
		
		return "/imovel/pesquisarImovel";
	}
}
