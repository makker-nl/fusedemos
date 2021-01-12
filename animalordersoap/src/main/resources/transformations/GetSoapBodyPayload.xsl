<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
	<xsl:template match="/">
		<xsl:copy-of select="/soapenv:Envelope/soapenv:Body/*[1]" />
	</xsl:template>
</xsl:stylesheet>