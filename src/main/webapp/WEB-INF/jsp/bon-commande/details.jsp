<%@ page import="com.source.meuble.achat.bonCommande.BonCommande" %>
<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.achat.bonCommande.bonCommandeFille.BonCommandeFille" %>
<%@ page import="com.source.meuble.utilisateur.Utilisateur" %>
<%@ page import="com.source.meuble.utilisateur.UserRole" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Nathanalex
  Date: 01/11/2024
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    Utilisateur u = ((Utilisateur) request.getAttribute("u"));
    BonCommande bc = ((BonCommande) request.getAttribute("bc"));
    List<BonCommandeFille> bcfs = ((List<BonCommandeFille>) request.getAttribute("bcf"));

%>

<script>
    const questions = [];

    <%
    if(u.hasRole(UserRole.DEPT_FINANCE) && bc.getEtat() == 0) {
    %>
        questions.push("Est-ce que les fonds disponibles sont assez pour l’achat?");
        questions.push("Est-ce qu’il y a le budget pour l’achat?");
    <%
        }
    %>

    <%
    if(u.hasRole(UserRole.DIRECTION) && bc.getEtat() == 1) {
    %>
        questions.push("Validation interne effectué?");
    <%
        }
    %>

    const commandeQuestion = [
        "Voulez-vous vraiment faire une commande?"
    ];

    const brQuestion = [
        "Est-ce que les biens livrés correspondent au bon de commande?",
        "Est-ce que les biens livrés sont en bon état?"
    ]

</script>

<%
    if (u.getRole() == UserRole.DIRECTION && bc.isValide()) {
%>
<form action="/bon-commande/commander" method="post" id="commandeForm">
    <div class="flex">
        <div class="d-flex justify-content-center">
            <div class="card mb-4 w-50">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h5 class="mb-0">Faire Une Commade</h5>
                    <%--                <small class="text-muted float-end">Demandeur: <%=u.getRole().name()%></small>--%>
                </div>
                <div class="card-body">
                    <input type="hidden" name="idBc" value="<%=bc.getId()%>">
                    <div class="mb-3">
                        <label class="form-label" for="i1">Date Commande: </label>
                        <input type="date" id="i1" class="form-control" name="dateCommande" value="<%=LocalDate.now()%>">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="i2">Date Livraison prévu: </label>
                        <input type="date" id="i2" class="form-control" name="dateLivraison" value="<%=LocalDate.now()%>">
                    </div>

                    <input type="hidden" name="type" value="fournisseur">
                    <button type="button" class="btn btn-primary" onclick="showAlertBeforeSubmit(event, 'commandeForm', commandeQuestion)">Commander</button>
                </div>
            </div>
        </div>
    </div>
</form>
<%
    }
%>

<%
    if (bc.getEtat() == 2 && !u.hasRole(UserRole.DIRECTION)) {
%>
    <div class="d-flex justify-content-center">
        <div class="alert alert-warning">
            La direction est responsable du commande des biens
        </div>
    </div>

<%
    }
%>

<%
    if (bc.getEtat() == 3 && u.hasRole(UserRole.DEPT_LOGISTIQUE)) {
%>

<form action="/bon-reception/generer" method="post" id="brForm">
    <div class="flex">
        <div class="d-flex justify-content-center">
            <div class="card mb-4 w-50">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h5 class="mb-0">Generer Bon de Reception</h5>
                    <%--                <small class="text-muted float-end">Demandeur: <%=u.getRole().name()%></small>--%>
                </div>
                <div class="card-body">
                    <input type="hidden" name="idBc" value="<%=bc.getId()%>">
                    <input type="hidden" name="type" value="fournisseur">
                    <div class="mb-3">
                        <label class="form-label" for="i3">Date Reception: </label>
                        <input type="date" id="i3" class="form-control" name="dateReception" value="<%=bc.getDateLivraison()%>" max="<%=LocalDate.now()%>">
                    </div>


                    <button type="button" class="btn btn-primary" onclick="showAlertBeforeSubmit(event, 'brForm', brQuestion)">Recevoir</button>
                </div>
            </div>
        </div>
    </div>
</form>

<%
    }
    if (bc.getEtat() == 3 && !u.hasRole(UserRole.DEPT_LOGISTIQUE)) {
%>
<div class="d-flex justify-content-center">
    <div class="alert alert-warning">
        Le departement Logistique est responsable de la Reception
    </div>
</div>
<%
    }
%>

<div class="card">
    <input type="hidden" name="proformat" value="<%=bc.getId()%>">
    <h5 class="card-header">
        <strong>Details du Bon de Commande: </strong> BC000<%=bc.getId()%> du <%=bc.getDateCommande()%> <br>
        <strong> Fournisseur: </strong> FRN000<%=bc.getIdFournisseur().getId()%> - <%=bc.getIdFournisseur().getNom()%> <br>
        <strong>Etat: <%=bc.getEtatHtml()%>
        </strong>

    </h5>
    <div class="table-responsive text-nowrap">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Produit</th>
                <th>Prix Unitaire</th>
                <th>Qte</th>
            </tr>
            </thead>
            <tbody class="table-border-bottom-0">
            <%
                for (BonCommandeFille bcf : bcfs) {
            %>
            <tr>
                <td>BCF000<%=bcf.getId()%>
                <td>PRD000<%=bcf.getIdMarchandise().getId()%> - <%=bcf.getIdMarchandise().getLibelle()%>
                </td>
                <td class="text-right"><%=String.format("%.2f", bcf.getPrix())%>
                </td>
                <td><%=bcf.getQuantite()%> <%=bcf.getIdMarchandise().getUniteOeuvre().getNom()%>
                </td>

            </tr>
            <%
                }
            %>
            </tbody>
        </table>

        <%
            if ((u.hasRole(UserRole.DEPT_FINANCE) && bc.getEtat() == 0) || (u.hasRole(UserRole.DIRECTION) && bc.getEtat() == 1)) {
        %>
        <div class="d-flex justify-content-center m-2">
            <a href="/bon-commande/valider?id=<%=bc.getId()%>" onclick="showAlert(event, this, questions)">
                <button class="btn btn-warning">Valider</button>
            </a>
        </div>
        <%
            }
        %>


    </div>

</div>

