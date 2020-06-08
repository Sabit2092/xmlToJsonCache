# xmlToJsonCache
Connvert XML to JSON in Cache Object Script

For import Jar to Cache, should open STUDIO -> Tools -> Add-Ins -> Master Java Gateway

First put path to jar file named xmlToJson.jar

Second, put path to json-20180813.jar to Additional ClassPaths field

After import, the converter can be called like this:

ClassMethod xmlToJson(message As %String) As %Status
{
	Set result = $$$OK
	
	try {
		Set gateway=##class(%Net.Remote.Gateway).%New()
	 	Set status=gateway.%Connect("127.0.0.1",55555)
	 	
	 	if 'status Quit	
	 	set obj = ##class(ParseXML.Parse).%New(gateway) 	
	 	set res = obj.convertXMLtoJSON(message)
	 	
	 	Set result = res
	}Catch ex {
		Do ex.Log()
		Write ex.DisplayString(),!
		ZWrite %objlasterror
	}
	
 	Quit result
}

