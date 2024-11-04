<%@ page import="com.source.meuble.achat.BonReception.BonReception" %>
<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.vente.BonLivraison.BonLivraisonFille.BonLivraisonFille" %>
<%@ page import="com.source.meuble.vente.BonLivraison.BonLivraison" %>
<%@ page import="com.source.meuble.vente.BonLivraison.BonLivraisonFille.BonLivraisonFille" %><%--
  Created by IntelliJ IDEA.
  User: Nathanalex
  Date: 01/11/2024
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BonLivraison bl = ((BonLivraison) request.getAttribute("bl"));
    List<BonLivraisonFille> blfs = ((List<BonLivraisonFille>) request.getAttribute("blf"));
%>

<div class="flex">
    <div class="d-flex justify-content-center">
        <div class="card mb-4 w-50">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h5 class="mb-0">Details Bon de Livraison</h5>
                <%--                <small class="text-muted float-end">Demandeur: <%=u.getRole().name()%></small>--%>
            </div>
            <div class="card-body">
                <table class="table table-borderless">
                    <tr>
                        <td class="bold">Numero:</td>
                        <td>BL000<%=bl.getId()%></td>
                    </tr>
                    <tr>
                        <td class="bold">Date Livraison:</td>
                        <td><%=bl.getDateLivraison()%></td>
                    </tr>
                    <tr>
                        <td class="bold">Numero Bon Commade:</td>
                        <td>BC000<%=bl.getIdBc().getId()%></td>
                    </tr>
                    <tr>
                        <td class="bold">Fournisseur:</td>
                        <td> FRN000<%=bl.getIdBc().getIdClient().getId()%> - <%=bl.getIdBc().getIdClient().getNom()%></td>
                    </tr>

                    <tr>
                        <td class="bold">Etat:</td>
                        <td> <%=bl.getEtat()%></td>
                    </tr>
                </table>

                <div class="d-flex justify-content-end m-2 gap-2">

                    <a href="">
                        <button class="btn btn-primary">Valider</button>
                    </a>
                    <form action="/facture/generer" method="post">
                        <input type="hidden" name="idBr" value="<%=bl.getId()%>"/>
                        <button type="submit" class="btn btn-warning" >Generer Facture</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="card">
    <input type="hidden" name="proformat" value="<%=bl.getId()%>">
    <h5 class="card-header">
        Liste Produits

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
                for (BonLivraisonFille blf : blfs) {
            %>
            <tr>
                <td>BLF000<%=blf.getId()%>
                <td>PRD000<%=blf.getIdProduit().getId()%> - <%=blf.getIdProduit().getLibelle()%>
                </td>
                <td class="text-right"><%=String.format("%.2f", blf.getPrix())%>
                </td>
                <td><%=blf.getQuantite()%> <%=blf.getIdProduit().getUniteOeuvre().getNom()%>
                </td>

            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

</div>


