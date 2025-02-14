package com.source.meuble.achat.proformat;

import com.source.meuble.achat.Client.Client;
import com.source.meuble.achat.Client.ClientService;
import com.source.meuble.achat.Fornisseur.Fournisseur;
import com.source.meuble.achat.Fornisseur.FournisseurService;
import com.source.meuble.achat.besoin.Besoin;
import com.source.meuble.achat.besoin.BesoinService;
import com.source.meuble.achat.proformat.proformatFille.ProformatFille;
import com.source.meuble.analytique.centre.CentreRepository;
import com.source.meuble.analytique.produit.Produit;
import com.source.meuble.analytique.produit.ProduitService;
import com.source.meuble.auth.AuthService;
import com.source.meuble.auth.LayoutService;
import com.source.meuble.exception.Alert;
import com.source.meuble.exception.NoExerciceFoundException;
import com.source.meuble.exception.NoUserLoggedException;
import com.source.meuble.talent.recrutement.RecrutementRepository;
import com.source.meuble.util.Layout;
import com.source.meuble.util.Redirection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/proformat")
public class ProformatController {

    private final ProformatService proformatService;


    private final LayoutService layoutService;
    private final BesoinService besoinService;
    private final FournisseurService fournisseurService;
    private final ProduitService produitService;
    private final ClientService clientService;
    private final RecrutementRepository recrutementRepository;

    public ProformatController(ProformatService proformatService, LayoutService layoutService, BesoinService besoinService, FournisseurService fournisseurService, ProduitService produitService, ClientService clientService,
                               RecrutementRepository recrutementRepository) {
        this.proformatService = proformatService;
        this.layoutService = layoutService;
        this.besoinService = besoinService;
        this.fournisseurService = fournisseurService;
        this.produitService = produitService;
        this.clientService = clientService;
        this.recrutementRepository = recrutementRepository;
    }

//    @GetMapping("/liste")
//    public ModelAndView showList() {
//        ModelAndView modelAndView = new ModelAndView("template");
//
//        String content = "landingAchat.jsp";
//        String sidebar = "template/floating-sidebar-achat.jsp";
//        String validation = "achat/proformat.jsp";
//        modelAndView.addObject("content", content);
//        modelAndView.addObject("sidebar", sidebar);
//        modelAndView.addObject("insideContent", validation);
//        modelAndView.addObject("centres", centreRepository.findAll());
//        modelAndView.addObject("produits", marchandiseService.findAll());
//        return modelAndView;
//    }

    @GetMapping("/form")
    public ModelAndView showForm() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("proformat/form");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("besoins", besoinService.getBesoins(2));
        mav.addObject("fournisseurs", fournisseurService.findAllFournisseur());
        return mav;
    }

    @GetMapping("/formClient")
    public ModelAndView showFormClient() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("proformat/formClient");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("produits", produitService.findAll());
        mav.addObject("clients", clientService.findAll());
        return mav;
    }

    @GetMapping("/list")
    public ModelAndView showList() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("proformat/list");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("proformats", proformatService.getAllProformatsFournisseur());
        return mav;
    }

    @GetMapping("/listClient")
    public ModelAndView showListClient() throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("proformat/listClient");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("proformats", proformatService.getAllProformatsClient());
        return mav;
    }

    @GetMapping("/details")
    public ModelAndView showDetails(
        @RequestParam("id") Proformat proformat
    ) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("proformat/details");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("proformat", proformat);
        mav.addObject("pfs", proformat.getFilles());
        return mav;
    }

    @GetMapping("/details-recru")
    public ModelAndView showDetailsRecru(
            @RequestParam("id") Proformat proformat
    ) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("proformat/details-recru");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("proformat", proformat);
        mav.addObject("recrutements", recrutementRepository.findAll());
        mav.addObject("pfs", proformat.getFilles());
        return mav;
    }

    @GetMapping("/detailsClient")
    public ModelAndView showDetailsClient(
            @RequestParam("id") Proformat proformat
    ) throws NoUserLoggedException, NoExerciceFoundException {
        Layout layout = layoutService.getLayout("proformat/detailsClient");
        ModelAndView mav = layout.getModelAndView();
        mav.addObject("proformat", proformat);
        mav.addObject("pfs", proformat.getFilles());
        return mav;
    }

//    @GetMapping("/details")
//    public ModelAndView afficherDetails(
//        @RequestParam("id") Proformat proformat
//    ) {
//        ModelAndView modelAndView = new ModelAndView("template");
//
//        String content = "landingAchat.jsp";
//        String sidebar = "template/floating-sidebar-achat.jsp";
//        String validation = "achat/proformat-detail.jsp";
//        modelAndView.addObject("content", content);
//        modelAndView.addObject("sidebar", sidebar);
//        modelAndView.addObject("insideContent", validation);
//        modelAndView.addObject("centres", centreRepository.findAll());
//        modelAndView.addObject("produits", marchandiseService.findAll());
//        modelAndView.addObject("pfs", proformat.getFilles());
//        return modelAndView;
//    }

    @PostMapping("/demande")
    public String demanderProformat(
        @RequestParam("besoin[]") List<Besoin> besoins,
        @RequestParam("fournisseur")Fournisseur fournisseur,
        RedirectAttributes atts
    ) {
        proformatService.demanderProformat(besoins, fournisseur);
        atts.addFlashAttribute("swal", Alert.success("Proformat a été bien generé"));
        return new Redirection("/proformat/list").getUrl();
    }

    @PostMapping("/demandeClient")
    public String demanderProformatClient(
            @RequestParam("produit[]") List<Produit> produits,
            @RequestParam("client") Client client
    ) {
        proformatService.demanderProformat(produits, client);
        return new Redirection("/proformat/listClient").getUrl();
    }

    @PostMapping("/ajouter-prix")
    public String ajouterPrixProformat(
        @RequestParam("proformat") Proformat proformat,
        @RequestParam("pf[]") List<ProformatFille> pfs,
        @RequestParam("prix[]") List<Double> prixList,
        RedirectAttributes atts
    ) throws Exception {
        proformatService.ajouterPrixProformat(proformat, pfs.toArray(new ProformatFille[0]), prixList.toArray(new Double[0]));

        atts.addFlashAttribute("swal", Alert.success("Prix bien ajouté pour le proformat: PF000" + proformat.getId()));
        if (proformat.getIdClient() == null) {
            return new Redirection("/proformat/details?id=" + proformat.getId()).getUrl();
        }

        return new Redirection("/proformat/detailsClient?id="+proformat.getId()).getUrl();
    }

    @PostMapping("/completer")
    public String ajouterPrixQtiteProformat(
            @RequestParam("proformat") Proformat proformat,
            @RequestParam("pf[]") List<ProformatFille> pfs,
            @RequestParam("prix[]") List<Double> prixList,
            @RequestParam("qte[]") List<Double> qteList,
            RedirectAttributes atts
    ) throws Exception {
        proformatService.ajouterPrixProformat(proformat, pfs.toArray(new ProformatFille[0]), prixList.toArray(new Double[0]));
        proformatService.ajouterQtiteProformat(proformat, pfs.toArray(new ProformatFille[0]), qteList.toArray(new Double[0]));

        atts.addFlashAttribute("swal", Alert.success("Prix et quantite bien ajouté pour le proformat: PF000" + proformat.getId()));
        if (proformat.getIdClient() == null) {
            return new Redirection("/proformat/details?id=" + proformat.getId()).getUrl();
        }

        return new Redirection("/proformat/detailsClient?id="+proformat.getId()).getUrl();
    }
}
