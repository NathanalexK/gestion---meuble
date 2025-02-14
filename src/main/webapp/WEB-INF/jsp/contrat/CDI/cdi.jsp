<%@ page import="com.source.meuble.talent.personnel.Personnel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Tsinjoniaina
  Date: 11/9/2024
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%
  Personnel personnel = (Personnel) request.getAttribute("personnel");
%>
<script src="../../../../assets/js/html2pdf.bundle.min.js"></script>

<div class="d-flex justify-content-center">
<div class="container" id="pdfContent">
  <div class="header">
    <p class="title">CONTRAT A DUREE INDETERMINEE</p>
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
    <p class="indent"><%= personnel.getNom()+" "+personnel.getPrenom()%> est engagé(e) sous Contrat de travail à durée indéterminée en <%= personnel.getIdRole()%> à compter du <%= personnel.getDateEmbauche()%>.</p>
    <p class="indent">Le Salarié qui accepte cet engagement, déclare être délié de tout engagement de non-concurrence à l'égard de son ou ses employeurs précédents lui interdisant de travailler pour la Société ou avec l'un quelconque des clients de la Société.</p>
    <p class="indent">Le Contrat et ses avenants sont régis par les dispositions de la Convention Collective Nationale SYNTEC, du 01/08/1988 numéro 1486.</p>
  </div>
</div>
</div>

<button class="export-btn" onclick="exportCDItoPDF()">Exporter en PDF</button>

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