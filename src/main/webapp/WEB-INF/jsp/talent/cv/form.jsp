<%@ page import="java.util.List" %>
<%@ page import="com.source.meuble.achat.besoin.Besoin" %>
<%@ page import="com.source.meuble.achat.Fornisseur.Fournisseur" %>
<%@ page import="com.source.meuble.talent.offreEmploi.OffreEmploi" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.source.meuble.talent.diplome.Diplome" %><%--
  Created by IntelliJ IDEA.
  User: Nathanalex
  Date: 01/11/2024
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    OffreEmploi of = ((OffreEmploi) request.getAttribute("offre"));
    List<Diplome> diplomes = (List<Diplome>) request.getAttribute("diplomes");
%>

<script>
    const questions = [
        'Tous les informations sont-ils correcte?',
        'Le CV correspond-il aux critères de l’offre ?',
        'Vérification de la qualité du CV'
    ];
</script>

<div class="flex">
    <div class="d-flex justify-content-center">
        <div class="card mb-4 w-50">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h5 class="mb-0">Ajouter CV à l'offre: <%= of.getId() %></h5>
<%--                <small class="text-muted float-end">Demandeur: <%=u.getRole().name()%></small>--%>
            </div>
            <div class="card-body">
                <form action="/cv/save" method="POST">
                    <div class="mb-3">
                        <label class="form-label" for="text-input">Nom:</label>
                        <input type="text" step="0.01" id="text-input" class="form-control" value="Jeff" name="nom">
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="text-input">Prenom:</label>
                        <input type="text" step="0.01" id="text-input" class="form-control" value="Besosy" name="prenom">
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="text-input">Adresse:</label>
                        <input type="text" step="0.01" id="text-input" class="form-control" value="Lot 3245 Impossible Union" name="adresse">
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="date-input">Date de naissance: </label>
                        <input type="date" class="form-control" id="date-input" value="<%=LocalDate.now()%>" name="datePostulation">
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="date-input">Date postulation: </label>
                        <input type="date" class="form-control" id="date-input" value="<%=LocalDate.now()%>" name="dateNaissance">
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="produit">Produit: </label>
                        <select name="idDiplome" id="produit" class="form-select">
                            <%
                                for(Diplome diplome: diplomes) {
                            %>
                            <option value="<%=diplome.getId_diplome()%>">DPL000<%=diplome.getId_diplome()%> - <%=diplome.getLibelle()%></option>
                            <%
                                }
                            %>
                            <option id="addProduit" value="$">+ Ajouter un nouveau produit</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="qte-input">Annee d'experience:</label>
                        <input type="number" step="0.01" id="qte-input" class="form-control" value="1" name="anneesExperience">
                    </div>
                    <input type="hidden" name="idOffreEmploi" value=<%=of.getId()%>>


                    <button type="submit" class="btn btn-primary">Valider</button>
                </form>
            </div>
        </div>
    </div>
</div>

