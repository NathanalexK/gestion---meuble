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

<form action="/poste-fille/traitement" method="post" id="proformatForm">
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



                    <div class="mb-3" id="posteFilleDiv">
                        <label class="form-label" for="posteFille">Poste filles : </label>
                        <select name="posteFille" id="posteFille" class="form-select">
                            <option disabled selected>Veuillez choisir une poste secondaire</option>
                        </select>
                    </div>
                    <di class="mb-3" id="libelle"></di>
                    <div class="mb-3">
                        <label class="form-label" for="qte-input">Montant (AR) :</label>
                        <input type="number" step="0.01" id="qte-input" class="form-control" name="montant">
                    </div>

                    <button onclick="showAlertBeforeSubmit(event, 'proformatForm', questions)" type="button" class="btn btn-primary">Valider</button>
                </div>
            </div>
        </div>
    </div>
</form>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        const posteMere = document.getElementById('posteMere');
        const posteFilleDiv = document.getElementById("posteFilleDiv");
        var secondSelects = document.querySelectorAll('#posteFille');
        var posteFille = secondSelects[secondSelects.length-1];

        posteMere.addEventListener('change', function () {
            const selectedValue = posteMere.value;


            let url = "/api/poste-fille/nomposte-corres?idPosteMere=" + selectedValue;
            console.log("URL générée :", url);

            console.log(selectedValue)

            fetch(url)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Erreur lors de la récupération des données');
                    }
                    return response.json();
                })
                .then(data => {
                    posteFille.innerHTML = '<option disabled selected >Veuillez choisir une poste secondaire</option>';
                    console.log(data.valueOf());
                    // Ajouter les nouvelles options
                    data.forEach(item => {
                        const option = document.createElement('option');
                        option.value = item.compte;
                        option.textContent = item.libelle;
                        posteFille.appendChild(option);
                    });
                })
                .catch(error => {
                    console.error(error);
                    alert('Une erreur est survenue lors du chargement des données.');
                });
        });

        posteFille.addEventListener('change', function () {
            fetchCompteFille(posteFille, posteFilleDiv);
        });

        function fetchCompteFille(posteFille, posteFilleDiv) {
            console.log(posteFille.value);

            let selectedValue = posteFille.value;
            let url = "/api/poste-fille/compte-corres?compteMere=" + selectedValue;
            console.log("URL générée :", url);

            fetch(url)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Erreur lors de la récupération des données');
                    }
                    return response.json();
                })
                .then(data => {
                    var br = document.createElement('br');
                    posteFilleDiv.appendChild(br);

                    if (data.length > 0) {
                        var newSelect = document.createElement('select');
                        newSelect.name = "posteFille";
                        newSelect.id = "posteFille";
                        newSelect.classList.add('form-select');

                        var defaultOption = document.createElement('option');
                        defaultOption.disabled = true;
                        defaultOption.selected = true;
                        defaultOption.textContent = "Veuillez choisir une poste secondaire";
                        newSelect.appendChild(defaultOption);

                        data.forEach(item => {
                            const option = document.createElement('option');
                            option.value = item.compte;
                            option.textContent = item.libelle;
                            newSelect.appendChild(option);
                        });

                        posteFilleDiv.appendChild(newSelect);

                        newSelect.addEventListener('change', function () {
                            fetchCompteFille(newSelect, posteFilleDiv);
                        });
                    } else {
                        var libelleDiv = document.getElementById("libelle");

                        var label = document.createElement('label');
                        label.classList.add('form-label');
                        label.setAttribute('for', 'libelle');
                        label.textContent = 'Libelle :';

                        var input = document.createElement('input');
                        input.id = 'libelle';
                        input.classList.add('form-control');
                        input.name = 'libelle';

                        libelleDiv.appendChild(label);
                        libelleDiv.appendChild(input);
                    }

                }).catch(error => {
                console.error(error);
                alert('Une erreur est survenue lors du chargement des données.');
            });
        }
    });
</script>
