<%@ page import="com.source.meuble.achat.BonReception.BonReception" %>
<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.achat.BonReception.BonReceptionFille.BonReceptionFille" %>
<%@ page import="com.source.meuble.utilisateur.UserRole" %>
<%@ page import="com.source.meuble.utilisateur.Utilisateur" %><%--
  Created by IntelliJ IDEA.
  User: Nathanalex
  Date: 01/11/2024
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Utilisateur u = ((Utilisateur) request.getAttribute("u"));
    BonReception br = ((BonReception) request.getAttribute("br"));
    List<BonReceptionFille> brfs = ((List<BonReceptionFille>) request.getAttribute("brf"));
%>

<script>
    const question = [
        'Les biens sont-ils bien reçu?',
        'Les informations sont tous corrects?'
    ];
</script>

<div class="flex">
    <div class="d-flex justify-content-center">
        <div class="card mb-4 w-50">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h5 class="mb-0">Details Bon de Reception</h5>
                <%--                <small class="text-muted float-end">Demandeur: <%=u.getRole().name()%></small>--%>
            </div>
            <div class="card-body">
                <table class="table table-borderless">
                    <tr>
                        <td class="bold">Numero:</td>
                        <td>BR000<%=br.getId()%>
                        </td>
                    </tr>
                    <tr>
                        <td class="bold">Date Reception:</td>
                        <td><%=br.getDateReception()%>
                        </td>
                    </tr>
                    <tr>
                        <td class="bold">Numero Bon Commade:</td>
                        <td>BC000<%=br.getIdBc().getId()%>
                        </td>
                    </tr>
                    <tr>
                        <td class="bold">Fournisseur:</td>
                        <td> FRN000<%=br.getIdBc().getIdFournisseur().getId()%> - <%=br.getIdBc().getIdFournisseur().getNom()%>
                        </td>
                    </tr>

                    <tr>
                        <td class="bold">Etat:</td>
                        <td><%=br.getEtatHtml()%>
                        </td>
                    </tr>
                </table>

                <div class="d-flex justify-content-end m-2 gap-2">

                    <%
                        if (u.hasRole(UserRole.DEPT_FINANCE)) {
                    %>
                    <form action="/facture/generer" method="post">
                        <input type="hidden" name="idBr" value="<%=br.getId()%>"/>
                        <button type="submit" class="btn btn-warning">Generer Facture</button>
                    </form>
                    <%
                        } else {
                    %>
                    <div class="d-flex justify-content-center">
                        <div class="alert alert-warning">
                            Le departement Finance peut générer la facture
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="card">
    <input type="hidden" name="proformat" value="<%=br.getId()%>">
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
                for (BonReceptionFille brf : brfs) {
            %>
            <tr>
                <td>BRF000<%=brf.getId()%>
                <td>PRD000<%=brf.getIdMarchandise().getId()%> - <%=brf.getIdMarchandise().getLibelle()%>
                </td>
                <td class="text-right"><%=String.format("%.2f", brf.getPrix())%>
                </td>
                <td><%=brf.getQuantite()%> <%=brf.getIdMarchandise().getUniteOeuvre().getNom()%>
                </td>

            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

</div>


