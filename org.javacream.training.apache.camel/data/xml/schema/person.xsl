<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
  <table border="1">
    <xsl:for-each select="person">
    <tr>
      <td><xsl:value-of select="vorname"/></td>
      <td><xsl:value-of select="nachname"/></td>
    </tr>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet> 