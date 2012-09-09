<html>
<head><title>Rules Demo - SecureLink by Barton Hammond</title>

<style>
body, input {
	font-family: Calibri, Arial;
	margin: 0px;
	padding: 0px;
}
#header h2 {
	color: white;
	background-color: #3275A8;
	height: 50px;
	padding: 5px 0 0 5px;
	font-size: 22px;
}
	
.datatable {margin-bottom:5px;border:1px solid #eee;border-collapse:collapse;width:400px;max-width:100%;font-family:Calibri}
.datatable th {padding:3px;border:1px solid #888;height:30px;background-color:#B2D487;text-align:center;vertical-align:middle;color:#444444}
.datatable tr {border:1px solid #888}
.datatable tr.odd {background-color:#eee}
.datatable td {padding:2px;border:1px solid #888}
#content { padding 5px; margin: 5px; text-align: center}

fieldset { width: 300px; padding: 5px; margin-bottom: 0px; }
legend { font-weight: bold; }
</style>

<body>
<div id="header">
<H2>
	Rules Demo - Barton Hammond
</H2>

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
</body>
</html>  