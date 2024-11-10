<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.achat.proformat.proformatFille.ProformatFille" %>
<%@ page import="com.source.meuble.achat.proformat.Proformat" %>
<%@ page import="com.source.meuble.talent.recrutement.Recrutement" %>
<%--
  Created by IntelliJ IDEA.
  User: Nathanalex
  Date: 01/11/2024
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    Proformat proformat = ((Proformat) request.getAttribute("proformat"));
    List<ProformatFille> pfs = ((List<ProformatFille>) request.getAttribute("pfs"));
    List<Recrutement> recrutements = ((List<Recrutement>) request.getAttribute("recrutements"));
%>

<script>
const questions = [
        'Est-ce que les besoins ne sont pas disponibles en stock?'
        ];

const questions1 = [
        'Avez vous reverifié les prix avant de valider?'
    ];
    const questions2 = [
        'Voulez-vous vraiment generer un bon de commande pour cette proformat?'
    ]
</script>

<form action="/offre-emploi/annoncer" method="POST" id="mineForm">
    <div class="card">
        <input type="hidden" name="proformat" value="<%=proformat.getId()%>">
        <h5 class="card-header">
            <strong>Details du Proformat: </strong> PF000<%=proformat.getId()%> du <%=proformat.getDaty()%> <br>
            <strong> Fournisseur: </strong> FRN000<%=proformat.getIdFournisseur().getId()%> - <%=proformat.getIdFournisseur().getNom()%> <br>
            <strong>Etat: <%=proformat.getEtatHtml()%></strong>

        </h5>
        <div class="table-responsive text-nowrap">
            <table class="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Produit</th>
                    <th>Qte</th>
                    <th>Prix Unitaire</th>
                </tr>
                </thead>
                <tbody class="table-border-bottom-0">
                <%
                    for (ProformatFille pf : pfs) {
                %>
                <tr>
                    <td>PFF000<%=pf.getId()%>
                    <td>PRD000<%=pf.getId()%> - <%=pf.getIdMarchandise().getLibelle()%></td>
                    <td><%=pf.getQte()%> <%=pf.getIdMarchandise().getUniteOeuvre().getNom()%>
                    </td>
                    <td>
                        <input type="hidden" name="pf[]" value="<%=pf.getId()%>">
                        <input type="number" class="form-control" step="0.01" name="prix[]" value="<%=pf.getPrix()%>">
                    </td>

                </tr>
                <%
                    }
                %>

                </tbody>
            </table>
            <div class="d-flex m-3 justify-content-center">
                <div>
                    <%
                        if(!proformat.isValide()) {
                    %>
                    <button type="button" onclick="showAlertBeforeSubmit(event, 'proformaForm', questions1)" class="btn btn-primary">Valider Proformat</button>
                    <%
                        }
                    %>
                    <%
                        if(proformat.isValide()) {
                    %>
                    <button onclick="showAlertBeforeSubmit(event, 'mineForm', questions)" type="button" class="btn btn-primary">Generer commande</button>
                    <%
                        }
                    %>
                </div>
            </div>

        </div>

    </div>

    <br>

    <div class="card">
        <h5 class="card-header">Inclure un besoin de recrutement</h5>
        <div class="table-responsive text-nowrap">
            <table class="table">
                <thead>
                <tr>
                    <th></th>
                    <th>ID</th>
                    <th>Departement</th>
                    <th>Savoir</th>
                    <th>Années d'experience</th>
                    <th>Date</th>
                </tr>
                </thead>
                <tbody class="table-border-bottom-0">
                <%
                    for (Recrutement recru : recrutements) {
                %>
                <tr>
                    <td><input class="form-check-input" type="checkbox" name="recru[]" value="<%=recru.getIdBesoin()%>"/></td>
                    <td><strong>BES000<%=recru.getIdBesoin()%>
                    </strong></td>
                    <td><%=recru.getIdRole()%>
                    </td>
                    <td><%=recru.getDiplome().getLibelle()%>
                    </td>
                    <td><%=recru.getAnneesExperience()%>
                    </td>
                    <td><%=recru.getDateDemande()%>
                    </td>

                </tr>
                <%
                    }
                %>

                </tbody>
            </table>
        </div>
    </div>

</form>



