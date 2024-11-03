<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.achat.besoin.Besoin" %>
<%@ page import="com.source.meuble.achat.Fornisseur.Fournisseur" %>
<%@ page import="com.source.meuble.analytique.produit.Produit" %>
<%@ page import="com.source.meuble.achat.Client.Client" %><%--
  Created by IntelliJ IDEA.
  User: Nathanalex
  Date: 01/11/2024
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Produit> besoins = ((List<Produit>) request.getAttribute("produits"));
    List<Client> frns = ((List<Client>) request.getAttribute("clients"));
%>

<form action="/proformat/demandeClient" method="post">
    <div class="flex">
        <div class="d-flex justify-content-center">
            <div class="card mb-4 w-50">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h5 class="mb-0">Reception demande de Proformat</h5>
                    <%--                <small class="text-muted float-end">Demandeur: <%=u.getRole().name()%></small>--%>
                </div>
                <div class="card-body">
                    <div class="mb-3">
                        <label class="form-label" for="produit">Client: </label>
                        <select name="client" id="produit" class="form-select">
                            <%
                                for (Client frn : frns) {
                            %>
                            <option value="<%=frn.getId()%>">CLT000<%=frn.getId()%> - <%=frn.getNom()%> [<%=frn.getCompte()%>]</option>
                            <%
                                }
                            %>
                            <option id="addProduit" value="$">+ Ajouter un nouveau Client</option>
                        </select>
                    </div>


                    <button type="submit" class="btn btn-primary">Valider</button>
                </div>
            </div>
        </div>
    </div>


    <div class="card">
        <h5 class="card-header">Inclure des produits dans le Proformat</h5>
        <div class="table-responsive text-nowrap">
            <table class="table">
                <thead>
                <tr>
                    <th></th>
                    <th>ID</th>
                    <th>Nom du Produit</th>
<%--                    <th>Quantite</th>--%>
<%--                    <th>Departement</th>--%>
<%--                    <th>Date</th>--%>
                </tr>
                </thead>
                <tbody class="table-border-bottom-0">
                <%
                    for (Produit besoin : besoins) {
                %>
                <tr>
                    <td><input class="form-check-input" type="checkbox" name="produit[]" value="<%=besoin.getId()%>"/></td>
                    <td><strong>PROD000<%=besoin.getId()%>
                    </strong></td>
                    <td><%=besoin.getLibelle()%>
                    </td>
<%--                    <td><%=String.format("%.2f", besoin.getQuantite())%>--%>
<%--                    </td>--%>
<%--                    <td><%=besoin.getRole().name()%>--%>
<%--                    </td>--%>
<%--                    <td><%=besoin.getDaty()%>--%>
<%--                    </td>--%>

                </tr>
                <%
                    }
                %>

                </tbody>
            </table>
        </div>
    </div>
</form>

