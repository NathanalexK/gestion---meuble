<%@ page import="com.source.meuble.talent.cv.Cv" %><%--
  Created by IntelliJ IDEA.
  User: Miarantsoa
  Date: 11/11/2024
  Time: 08:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Cv cv = (Cv) request.getAttribute("cv");
%>

<div class="flex">
    <div class="d-flex justify-content-center">
        <div class="card mb-4 w-50">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h5 class="mb-0">CV de <%=cv.getNom()+" "+cv.getPrenom()%></h5>
                <%--                <small class="text-muted float-end">Demandeur: <%=u.getRole().name()%></small>--%>
            </div>
            <div class="card-body">
                <div class="py-3 d-flex justify-content-between align-content-center">
                    <span><h4>Nom: </h4></span><span><%=cv.getNom()%></span>
                </div>
                <div class="py-3 d-flex justify-content-between align-content-center">
                    <span><h4>Prenom: : </h4></span><span><%=cv.getPrenom()%></span>
                </div>
                <div class="py-3 d-flex justify-content-between align-content-center">
                    <span><h4>Date de naissance: </h4></span><span><%=cv.getDateNaissance()%></span>
                </div>
                <div class="py-3 d-flex justify-content-between align-content-center">
                    <span><h4>Adresse: </h4></span><span><%=cv.getAdresse()%></span>
                </div>
                <div class="py-3 d-flex justify-content-between align-content-center">
                    <span><h4>Adresse e-mail: </h4></span><span><%=cv.getEmail()%></span>
                </div>
                <div class="py-3 d-flex justify-content-between align-content-center">
                    <span><h4>Telephone: </h4></span><span><%=cv.getTelephone()%></span>
                </div>
                <div class="py-3 d-flex justify-content-between align-content-center">
                    <span><h4>Diplome: </h4></span><span><%=cv.getIdDiplome().getLibelle()%></span>
                </div>
                <div class="py-3 d-flex justify-content-between align-content-center">
                    <span><h4>Experiences: </h4></span><span><%=cv.getAnneesExperience()%> ans</span>
                </div>
                <div class="py-3 d-flex justify-content-between align-content-center">
                    <span><h4>A postulé le: </h4></span><span><%=cv.getDatePostulation()%></span>
                </div>
            </div>
        </div>
    </div>
</div>
