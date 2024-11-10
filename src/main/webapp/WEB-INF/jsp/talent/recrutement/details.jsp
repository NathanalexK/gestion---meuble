<%@ page import="com.source.meuble.talent.recrutement.Recrutement" %><%--
  Created by IntelliJ IDEA.
  User: Miarantsoa
  Date: 10/11/2024
  Time: 03:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Recrutement rec = (Recrutement) request.getAttribute("recr");
%>

<div class="flex">
    <div class="d-flex justify-content-center">
        <div class="card mb-4 w-50">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h5 class="mb-0">Details recrutement</h5>
                <%--                <small class="text-muted float-end">Demandeur: <%=u.getRole().name()%></small>--%>
            </div>
            <div class="card-body">
                <div class="py-3 d-flex justify-content-between align-content-center">
                    <span><h4>Poste: </h4></span><span><%=rec.getIdRole()%></span>
                </div>
                <div class="py-3 d-flex justify-content-between align-content-center">
                    <span><h4>Detail du poste: </h4></span><span><%=rec.getDetails()%></span>
                </div>
                <div class="py-3 d-flex justify-content-between align-content-center">
                    <span><h4>Diplome: </h4></span><span><%=rec.getDiplome().getLibelle()%> - Niveau <%=rec.getDiplome().getNiveau()%></span>
                </div>
                <div class="py-3 d-flex justify-content-between align-content-center">
                    <span><h4>Experiences: </h4></span><span><%=rec.getAnneesExperience()%> ans</span>
                </div>
            </div>
        </div>
    </div>
</div>
