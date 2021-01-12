<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
	xmlns:anim="http://xmlns.vs.nl/fuse/demo/xsd/animalquotes">
	<xsl:template match="/">
		<soapenv:Envelope>
			<soapenv:Header />
			<soapenv:Body>
				<xsl:copy-of select="." />
			</soapenv:Body>
		</soapenv:Envelope>
	</xsl:template>
</xsl:stylesheet>