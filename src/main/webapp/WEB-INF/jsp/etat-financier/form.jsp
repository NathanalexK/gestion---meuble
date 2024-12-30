<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.achat.besoin.Besoin" %>
<%@ page import="com.source.meuble.achat.Fornisseur.Fournisseur" %>
<%@ page import="com.source.meuble.etatFinancier.Poste.Poste" %><%--
  Created by IntelliJ IDEA.
  User: Nathanalex
  Date: 01/11/2024
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Poste> postes = ((List<Poste>) request.getAttribute("postesMeres"));
%>

<script>
    const questions = [
        'Est-ce que les besoins ne sont pas disponibles en stock?'
    ];
</script>

<form action="/poste-fille/save" method="post" id="proformatForm">
    <div class="flex">
        <div class="d-flex justify-content-center">
            <div class="card mb-4 w-50">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <h5 class="mb-0">Ajout de poste</h5>
                    <%--                <small class="text-muted float-end">Demandeur: <%=u.getRole().name()%></small>--%>
                </div>
                <div class="card-body">
                    <div class="mb-3">
                        <label class="form-label" for="posteMere">Poste principal : </label>
                        <select name="posteMere" id="posteMere" class="form-select">
                            <option disabled selected >Veuillez choisir une poste mere</option>
                            <%
                                for (Poste poste : postes) {
                            %>
                            <option value="<%=poste.getId()%>"><%=poste.getLibelle()%></option>
                            <%
                                }
                            %>
                            <option id="addProduit" value="$">+ Ajouter un nouveau poste principal</option>
                        </select>

                    </div>



                    <div class="mb-3">
                        <label class="form-label" for="nomPoste">Nom poste : </label>
                        <select name="nomPoste" id="nomPoste" class="form-select">
                            <option disabled selected>Veuillez choisir une poste secondaire</option>
<%--                            <%--%>
<%--                                for (Fournisseur frn : frns) {--%>
<%--                            %>--%>
<%--                            <option value="<%=frn.getId()%>">FRN000<%=frn.getId()%> - <%=frn.getNom()%> [<%=frn.getCompte()%>]</option>--%>
<%--                            <%--%>
<%--                                }--%>
<%--                            %>--%>
                            <option id="addProduit" value="$">+ Ajouter un nouveau poste</option>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="qte-input">Montant (AR) :</label>
                        <input type="number" step="0.01" id="qte-input" class="form-control" name="montant">
                    </div>

                    <button onclick="showAlertBeforeSubmit(event, 'proformatForm', questions)" type="button" class="btn btn-primary">Valider</button>
                </div>
            </div>
        </div>
    </div>


<%--    <div class="card">--%>
<%--        <h5 class="card-header">Inclure les besoins dans le Proformat</h5>--%>
<%--        <div class="table-responsive text-nowrap">--%>
<%--            <table class="table">--%>
<%--                <thead>--%>
<%--                <tr>--%>
<%--                    <th></th>--%>
<%--                    <th>ID</th>--%>
<%--                    <th>Nom du Produit</th>--%>
<%--                    <th>Quantite</th>--%>
<%--                    <th>Departement</th>--%>
<%--                    <th>Date</th>--%>
<%--                </tr>--%>
<%--                </thead>--%>
<%--                <tbody class="table-border-bottom-0">--%>
<%--                <%--%>
<%--                    for (Besoin besoin : besoins) {--%>
<%--                %>--%>
<%--                <tr>--%>
<%--                    <td><input class="form-check-input" type="checkbox" name="besoin[]" value="<%=besoin.getId()%>"/></td>--%>
<%--                    <td><strong>BES000<%=besoin.getId()%>--%>
<%--                    </strong></td>--%>
<%--                    <td><%=besoin.getIdMarchandise().getLibelle()%>--%>
<%--                    </td>--%>
<%--                    <td><%=String.format("%.2f", besoin.getQuantite())%>--%>
<%--                    </td>--%>
<%--                    <td><%=besoin.getRole().name()%>--%>
<%--                    </td>--%>
<%--                    <td><%=besoin.getDaty()%>--%>
<%--                    </td>--%>

<%--                </tr>--%>
<%--                <%--%>
<%--                    }--%>
<%--                %>--%>

<%--                </tbody>--%>
<%--            </table>--%>
<%--        </div>--%>
<%--    </div>--%>
</form>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        const firstSelect = document.getElementById('posteMere');
        const secondSelect = document.getElementById('nomPoste');

        firstSelect.addEventListener('change', function () {
            const selectedValue = firstSelect.value;


            let url = "/api/poste-fille/nomposte-corres?idPosteMere=" + selectedValue;
            console.log("URL générée :", url);

            console.log(selectedValue)
            console.log("EEEEEEEE")

            fetch(url)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Erreur lors de la récupération des données');
                    }
                    return response.json();
                })
                .then(data => {
                    secondSelect.innerHTML = '<option disabled selected >Veuillez choisir une poste secondaire</option>';

                    // Ajouter les nouvelles options
                    data.forEach(item => {
                        const option = document.createElement('option');
                        option.value = item.id;
                        option.textContent = item.libelle;
                        secondSelect.appendChild(option);
                    });
                })
                .catch(error => {
                    console.error(error);
                    alert('Une erreur est survenue lors du chargement des données.');
                });
        });
    });
</script>
