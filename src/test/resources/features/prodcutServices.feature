Feature: user go to product and services and see the the regulations

Scenario Outline: user navigate to producto and services, to see the regulations

  Given user open application
  When navigate in the app to see the regulation
  Then validate that the url is correct "<urlPDF>"
  Examples:
    | urlPDF |
    |https://www.bancolombia.com/wcm/connect/www.bancolombia.com-26918/182d05c8-d942-42ca-9b3d-ddd0fe8772fe/Reglamento+Inversi%C3%B3n+Virtual.pdf?MOD=AJPERES&CVID=nPHYsMT|



