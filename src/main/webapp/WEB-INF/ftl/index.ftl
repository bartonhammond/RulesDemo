<html>
<head>
	<title>Rules Demo by Barton Hammond</title>
	<link rel="stylesheet" type="text/css" 	href="resources/css/rules.css" />	
</head>
<body>
<div id="header">
<h2>
	Rules Demo
	</h2>
</div>

<div id="content">
   
  <fieldset>
  	<legend>Input data</legend>
    <@s.form action="runRule" method="post">
        <@s.textfield label="Input integers" name="data.input"/>
        <@s.submit value="Run Rules"/>
    </@s.form>
	</fieldset>
  <br/>

  <table class="datatable">
  	<tr>
  		<th>Rule</th>  <th>Status</th>
  	</tr>
    <#list ruleResults as ruleResult>
  	<tr>
  		<td>${ruleResult.name}</td> <td>${ruleResult.message}</td>
  	</tr>
    </#list>
  </table>

</div>  
<div id="footer">
<p>For info see <a href="http://ibm.com/">Barton Hammond</a>
</div>

</body>
</html>  