<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.achat.besoin.Besoin" %>
<%@ page import="com.source.meuble.achat.Fornisseur.Fournisseur" %>
<%@ page import="com.source.meuble.talent.Publicite.FournisseurPub" %>
<%@ page import="com.source.meuble.talent.recrutement.Recrutement" %>
<%@ page import="com.source.meuble.achat.proformat.Proformat" %><%--
  Created by IntelliJ IDEA.
  User: Nathanalex
  Date: 01/11/2024
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Recrutement> recrutements = ((List<Recrutement>) request.getAttribute("recrutements"));
    List<Proformat> proformats = (List<Proformat>) request.getAttribute("proformats");
%>

<script>
    const questions = [
        'Est ce que le talent recherché n est pas déja disponible dans le personnel?',
        'Ameliorer les talents actuels peut-il resoudre le besoin?'
    ];
</script>

<%--    <div class="flex">--%>
<%--        <div class="d-flex justify-content-center">--%>
<%--            <div class="card mb-4 w-50">--%>
<%--                <div class="card-header d-flex justify-content-between align-items-center">--%>
<%--                    <h5 class="mb-0">Faire une annonce</h5>--%>
<%--                    &lt;%&ndash;                <small class="text-muted float-end">Demandeur: <%=u.getRole().name()%></small>&ndash;%&gt;--%>
<%--                </div>--%>
<%--                <div class="card-body">--%>
<%--                    <div class="mb-3">--%>
<%--                        <label class="form-label" for="produit">Fournisseur: </label>--%>
<%--                        <select name="fournisseur" id="produit" class="form-select">--%>
<%--                            <%--%>
<%--                                for (FournisseurPub frn : frns) {--%>
<%--                            %>--%>
<%--                            <option value="<%=frn.getId()%>">FRN000<%=frn.getId()%> - <%=frn.getNom()%> <%=frn.getPrix()%> : <%=frn.getMoyensStr()%></option>--%>
<%--                            <%--%>
<%--                                }--%>
<%--                            %>--%>
<%--                            <option id="addProduit" value="$">+ Ajouter un nouveau fournisseur</option>--%>
<%--                        </select>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

    <div class="card">
        <h5 class="card-header">Choix du fournisseur de publication</h5>
        <div class="table-responsive text-nowrap">
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Fournisseur</th>
                    <th>Date</th>
                    <th>Etat</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody class="table-border-bottom-0">
                <%
                    for (Proformat p : proformats) {
                %>
                <tr>
                    <td>
                        <strong>PF000<%=p.getId()%></strong>
                    </td>
                    <td>
                        FRN000<%=p.getIdFournisseur().getId()%> - <%=p.getIdFournisseur().getNom()%>
                    </td>
                    <td>
                        <%=p.getDaty()%>
                    </td>
                    <td>
                        <%=p.getEtatHtml()%>
                    </td>
                    <td>
                        <a href="/proformat/details-recru?id=<%=p.getId()%>">
                            <button class="btn btn-primary">Voir Details</button>
                        </a>
                    </td>
                </tr>
                <%
                    }
                %>

                </tbody>
            </table>
        </div>

    </div>

