package com.source.meuble.mock;

import com.source.meuble.utilisateur.UserRole;
import com.source.meuble.webComponent.Menu;
import com.source.meuble.webComponent.Sidebar;
import org.apache.catalina.User;

public class SidebarMock {
    public static final Sidebar DEFAULT_SIDEBAR = new Sidebar("bx bx-chair", "Mr Meuble") // logo + nom du projet
        .withLien("/home") // Lien lorsqu'on clique sur le logo
        .addMenu(
            // Menu: Besoin
            new Menu("Besoins")
                .withIcon("bx bx-briefcase-alt") // icon du menu: a voir sur: boxicons.com -> clique sur
                // icon -> font -> copier la class
                .withRoles()
                .addSubmenu(
                    new Menu("Demande de besoin") // Besoin (menu) -> Demande de Besoin (sous-menu du
                        // menu besoin)
                        .withIcon("bx bx-mail-send")
                        .withLien("/besoin/form")
                        .withRoles(UserRole.DIRECTION, UserRole.DEPT_ACHAT, UserRole.DEPT_VENTE, UserRole.DEPT_FINANCE, UserRole.DEPT_LOGISTIQUE, UserRole.PRODUCTION)
                )
                .addSubmenu(
                    new Menu("Validation Besoin") // Besoin -> Validation Besoin
                        .withIcon("bx bx-task")
                        .withLien("/besoin/list")
                        .withRoles(UserRole.DIRECTION, UserRole.DEPT_ACHAT) // Liste des
                    // departements qui
                    // peuvent voir le menu
                    // sur leur sidebar
                    // (vide si tout les
                    // depts peut acceder)
                ))
        .addMenu(
            // Menu: Achat
            new Menu("Achat")
                .withIcon("bx bx-cart-alt")
                .withLien("/test/layout")
                .withRoles(UserRole.DIRECTION, UserRole.DEPT_ACHAT, UserRole.DEPT_VENTE, UserRole.DEPT_FINANCE, UserRole.DEPT_LOGISTIQUE, UserRole.PRODUCTION)
                .addSubmenu(
                    new Menu("Proformat")
                        .withIcon("bx bx-receipt")
                        .withLien("")
                        .withRoles(UserRole.DIRECTION, UserRole.DEPT_ACHAT, UserRole.DEPT_VENTE, UserRole.DEPT_FINANCE, UserRole.DEPT_LOGISTIQUE, UserRole.PRODUCTION)
                        .addSubmenu(
                            new Menu("Demande Proformat")
                                .withIcon("bx bx-plus")
                                .withLien("/proformat/form"))
                        .addSubmenu(
                            new Menu("Validation Proformat")
                                .withIcon("bx bx-task")
                                .withLien("/proformat/list")))
                .addSubmenu(
                    new Menu("Bon de Commande")
                        .withIcon("bx bx-receipt")
                        .withLien("")
                        .withRoles(UserRole.DIRECTION, UserRole.DEPT_ACHAT, UserRole.DEPT_VENTE, UserRole.DEPT_FINANCE, UserRole.DEPT_LOGISTIQUE, UserRole.PRODUCTION)
                        .addSubmenu(
                            new Menu("Validation")
                                .withIcon("bx bx-task")
                                .withLien("/bon-commande/validation")
                                .withRoles(UserRole.DIRECTION, UserRole.DEPT_FINANCE))
                        .addSubmenu(
                            new Menu("Liste")
                                .withLien("/bon-commande/list")
                                .withIcon("bx bx-list-ol")))
                .addSubmenu(
                    new Menu("Bon de Reception")
                        .withIcon("bx bx-receipt")
                        .withLien("/bon-reception/list")
                        .withRoles(UserRole.DIRECTION, UserRole.DEPT_ACHAT, UserRole.DEPT_VENTE, UserRole.DEPT_FINANCE, UserRole.DEPT_LOGISTIQUE, UserRole.PRODUCTION))
                .addSubmenu(
                    new Menu("Facture Achat")
                        .withIcon("bx bx-file-blank")
                        .withLien("/facture/list")))
        .addMenu(
            new Menu("Stock")
                .withIcon("bx bx-cube")
                .withRoles(UserRole.DIRECTION, UserRole.DEPT_ACHAT, UserRole.DEPT_VENTE, UserRole.DEPT_FINANCE, UserRole.DEPT_LOGISTIQUE, UserRole.PRODUCTION)
                .addSubmenu(
                    new Menu("Mouvement de Stock")
                        .withIcon("bx bx-transfer")
                        .withLien("/mouvement-stock/list"))
                .addSubmenu(
                    new Menu("Etat de Stock")
                        .withIcon("bx bx-stats")
                        .withLien("/etat-stock/list")))
        .addMenu(
            new Menu("Produits")
                .withIcon("bx bx-box")
                .withRoles(UserRole.DIRECTION, UserRole.DEPT_ACHAT, UserRole.DEPT_VENTE, UserRole.DEPT_FINANCE, UserRole.DEPT_LOGISTIQUE, UserRole.PRODUCTION)
                .addSubmenu(
                    new Menu("Saisie Produit"))
                .addSubmenu(
                    new Menu("Saisie Recette"))
                .addSubmenu(
                    new Menu("Fabrication")))
        .addMenu(
            new Menu("Ventes")
                .withIcon("bx bx-box")
                .withRoles(UserRole.DIRECTION, UserRole.DEPT_ACHAT, UserRole.DEPT_VENTE, UserRole.DEPT_FINANCE, UserRole.DEPT_LOGISTIQUE, UserRole.PRODUCTION)
                .addSubmenu(
                    new Menu("Proformat")
                        .withIcon("bx bx-receipt")
                        .withLien("")
                        .withRoles(UserRole.DIRECTION, UserRole.DEPT_ACHAT, UserRole.DEPT_VENTE, UserRole.DEPT_FINANCE, UserRole.DEPT_LOGISTIQUE, UserRole.PRODUCTION)
                        .addSubmenu(
                            new Menu("Inserer dem. Proformat")
                                .withIcon("bx bx-plus")
                                .withLien("/proformat/formClient"))
                        .addSubmenu(
                            new Menu("Validation Proformat")
                                .withIcon("bx bx-task")
                                .withLien("/proformat/listClient")))
                .addSubmenu(
                    new Menu("Bon de Commande")
                        .withIcon("bx bx-receipt")
                        .withLien("")
                        .withRoles(UserRole.DIRECTION, UserRole.DEPT_ACHAT, UserRole.DEPT_VENTE, UserRole.DEPT_FINANCE, UserRole.DEPT_LOGISTIQUE, UserRole.PRODUCTION)
                        .addSubmenu(
                            new Menu("Validation")
                                .withIcon("bx bx-task")
                                .withLien("/bon-commande/validationClient")
                                .withRoles(UserRole.DIRECTION, UserRole.DEPT_FINANCE))
                        .addSubmenu(
                            new Menu("Liste")
                                .withLien("/bon-commande/listClient")
                                .withIcon("bx bx-list-ol")))

                .addSubmenu(
                    new Menu("Bon de Reception")
                        .withIcon("bx bx-receipt")
                        .withLien("/bon-reception/list")
                        .withRoles(UserRole.DIRECTION, UserRole.DEPT_ACHAT, UserRole.DEPT_VENTE, UserRole.DEPT_FINANCE, UserRole.DEPT_LOGISTIQUE, UserRole.PRODUCTION)
                )
                .addSubmenu(
                    new Menu("Bon de Livraison")
                        .withIcon("bx bx-receipt")
                        .withLien("")
                        .withRoles(UserRole.DIRECTION, UserRole.DEPT_ACHAT, UserRole.DEPT_VENTE, UserRole.DEPT_FINANCE, UserRole.DEPT_LOGISTIQUE, UserRole.PRODUCTION)
                        .addSubmenu(
                            new Menu("Validation")
                                .withIcon("bx bx-task")
                                .withLien("/bon-livraison/validation")
                                .withRoles(UserRole.DIRECTION, UserRole.DEPT_LOGISTIQUE)
                        )
                        .addSubmenu(
                            new Menu("List")
                                .withIcon("bx bx-task")
                                .withLien("/bon-livraison/list")
                        )
                )
        )
        .addMenu(
            new Menu("Personnel")
                .withIcon("bx bx-group")
                .withLien("")
                .withRoles(UserRole.DIRECTION, UserRole.RH)

        )
        .addMenu(
            new Menu("Recrutement")
                .withIcon("bx bx-user-plus")
                .withRoles(UserRole.DIRECTION, UserRole.RH)
                .addSubmenu(
                    new Menu("Inserer")
                        .withLien("/recrutement/add")

                )
                .addSubmenu(
                    new Menu("Liste")
                        .withLien("/recrutement/list")
                )

            )
            .addMenu(
                    new Menu("Offre d'emploi")
                            .withIcon("")
                            .addSubmenu(
                                    new Menu("Effectuer annonce")
                                            .withLien("/offre-emploi/form")

                            )
                            .addSubmenu(
                                    new Menu("Liste")
                                            .withLien("/offre-emploi/list")
                            )
                            .withRoles(UserRole.DIRECTION, UserRole.RH)

        )
        .addMenu(
            new Menu("CV")
                .withIcon("bx bx-id-card")
                .withLien("")
                .withRoles(UserRole.DIRECTION, UserRole.RH)

        )
        .addMenu(
            new Menu("Appel à l'action")
                .withIcon("")
                .withLien("")
                .withRoles(UserRole.DIRECTION, UserRole.RH)
                .addSubmenu(
                    new Menu("Test")
                        .withLien("/test/list")
                        .withRoles(UserRole.DIRECTION, UserRole.RH)
                )
                .addSubmenu(
                    new Menu("Entretien")
                        .withLien("/entretien/list")
                        .withRoles(UserRole.DIRECTION, UserRole.RH)
                )
        )
        .addMenu(
                new Menu("Etat financier")
                        .withIcon("")
                        .withLien("")
//                        .withRoles(UserRole.DIRECTION)
                        .addSubmenu(
                                new Menu("Ajouter poste")
                                        .withLien("/poste-fille/form")
//                                        .withRoles(UserRole.DIRECTION, UserRole.RH)
                        )
                        .addSubmenu(
                                new Menu("Analyse")
                                        .withLien("/etat-financier/analyse")
//                                        .withRoles(UserRole.DIRECTION, UserRole.RH)
                        )
        );
}
