<%@ page import="java.time.LocalDate" %>
<%@ page import="com.source.meuble.talent.cv.Cv" %><%--
  Created by IntelliJ IDEA.
  User: andyr
  Date: 10/11/2024
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cv cv= (Cv) request.getAttribute("cv");
%>
<div class="flex">
    <div class="d-flex justify-content-center">
        <div class="card mb-4 w-50">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h5 class="mb-0">Teste</h5>
            </div>
            <div class="card-body">
                <form action="/test/save" method="POST">
                    <div class="mb-3">
                        <label class="form-label">Id Cv:<%=cv.getId()%> </label>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Nom: <%=cv.getNom()%> </label>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Prenom: <%=cv.getPrenom()%> </label>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Offre d'emploie: <%=cv.getIdOffreEmploi().getId()%> </label>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Adresse: <%=cv.getAdresse()%> </label>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Annee d'experience: <%=cv.getAnneesExperience()%> </label>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Date postulation: <%=cv.getDatePostulation()%> </label>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Diplome: <%=cv.getIdDiplome()%> </label>
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="daty">Date:</label>
                        <input type="date" id="daty" class="form-control" name="daty"/>
                    </div>

                    <div class="mb-3">
                        <label class="form-label" for="note">Note:</label>
                        <input type="number" step="0.01" id="note" class="form-control" name="note"/>
                    </div>

                    <input type="hidden" name="id" value="<%=cv.getId()%>">
                    <button type="submit" class="btn btn-primary">Valider</button>
                </form>
            </div>
        </div>
    </div>
</div>