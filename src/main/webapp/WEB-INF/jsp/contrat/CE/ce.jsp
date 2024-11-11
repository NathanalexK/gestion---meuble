<%@ page import="com.source.meuble.talent.personnel.Personnel" %>
<%@ page import="com.source.meuble.talent.contrat.ContratEmploye.ContratEmploye" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Tsinjoniaina
  Date: 11/9/2024
  Time: 6:07 PM
  Model de Contrat à Durée Déterminée (CDD)
--%>
<%
    Personnel personnel = (Personnel) request.getAttribute("personnel");
    ContratEmploye contratEmploye = (ContratEmploye) request.getAttribute("contrat");
%>
<script src="../../../../assets/js/html2pdf.bundle.min.js"></script>

<div class="d-flex justify-content-center">
    <div class="container" id="pdfContent">
        <div class="header">
            <p class="title">CONTRAT D'ESSAIS</p>
            <p>Entre les soussignés:</p>
            <p>Entre les soussignés:</p>
            <p><strong>Directeur</strong><br>
                Mr Meuble<br>
                ITU Adoharanofotsy<br>
                Antananarivo 102<br>
                Représentée par Directeur General, agissant en qualité de Président<br>
                Ci-après dénommée par commodité «La Société»</p>
            <p>Et,</p>
            <p><strong><%= personnel.getNom()+" "+personnel.getPrenom()%></strong><br>
                Date et lieu de naissance: <%= personnel.getDateNaissance()%>, Madagascar<br>
                Adresse: <%= personnel.getAdresse()%><br>
                Ci-après dénommé par commodité «Le Salarié»</p>
        </div>

        <div class="content">
            <p>Il a été convenu ce qui suit:</p>
            <p class="section-title">Article 1 – Engagement</p>
            <p class="indent"><%= personnel.getNom()+" "+personnel.getPrenom()%> est engagé(e) sous Contrat d'essais en <%= personnel.getIdRole()%> à compter du <%= personnel.getDateEmbauche()%>, pour une durée de six mois.</p>

            <p class="section-title">Article 2 – Raison du CE</p>
            <p class="indent">Ce contrat est conclu pour faire face à un accroissement d'activité.</p>

            <p class="section-title">Article 4 – Rémunération</p>
            <p class="indent">Le Salarié percevra une rémunération mensuelle brute de <%= personnel.getSalaire()%> Ar.</p>

            <p class="section-title">Article 5 – Fin du Contrat</p>
            <p class="indent">Le présent contrat prendra fin de plein droit le <%= contratEmploye.getDateFin()%>.</p>
        </div>
    </div>
</div>

<button class="export-btn" onclick="exportCEtoPDF()">Exporter en PDF</button>

<p><h1>Promotion</h1></p>
<form action="/contrat/promotion" >
    <input type="hidden" name="personnel" value="<%= personnel.getId()%>">
    <input type="hidden" name="contrat" value="<%= contratEmploye.getId()%>">
    <input type="date" name="date" class="form-control">
    <button class="export-btn" type="submit">Promotion CDI</button>
</form>

<style>
    .container {
        background-color: white;
        width: 19cm;
        padding: 2cm;
        border: 1px solid #ddd;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        margin: 0 auto;
        float: left;
    }

    .title {
        text-align: center;
        font-size: 1.5em;
        font-weight: bold;
        margin-bottom: 1em;
    }

    .header, .content {
        margin-bottom: 20px;
        line-height: 1.6;
    }

    .section-title {
        font-weight: bold;
        margin-top: 20px;
    }

    .indent {
        margin-left: 20px;
    }

    .export-btn {
        display: block;
        margin: 20px auto;
        padding: 10px 20px;
        font-size: 1em;
        color: white;
        background-color: #6610f2;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    .export-btn:hover {
        background-color: #6f42c1;
    }
</style>

<script src="../../../../assets/js/contratToPdf.js"></script>
