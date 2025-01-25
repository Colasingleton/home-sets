
//////////
Part C
mainscreen.html Line 19 - Changed project name

mainscreen.html Line 12 - added css link for main page styles

mainscreen.html Line 23-33 - created a div 
container for a gallery of photos and added 
a link to the about us page

forms.css - linked to pages: InhousePartForm.html, OutsourcedPartForm.html,
ProductForm.html

Created pages - about.html, forms.css, about.css, mainscreen.css,AboutMeController
Created folders - static.images


///////////
Part D
about us page is completed with description and a link to mainscreen.html.
mainscreen.html - line 33 house line to about.html


//////////
Part E
bootstrapData.java - updated lines 40 - 133 with 5 parts and 5 products. 
program does not overwrite data in DB


//////////
Part F
mainscreen.html - line 64 - buy now it created next to other buttons.
AddPartController - lines 71-91 mapping for the buy now button maps to Success.html or Failure.html pages
AddPartController lines 87-88 parts inventory de-increments by one when purchased.

//////////
Part G
part.java - lines 31-16 & lines 99-107 - Added min and max getters and setters
mainscreen.html - lines 53-56 & lines 65-68 - Added new min and max inventory columns
BootStrapData.java - lines 104-141 - added min and max fields to the sample inventory
application.properties - line 6 - renamed persistent storage file
OutsourcedPartForm.html - lines 29-37 - added new min and max fields for the form - updated P tags with headers
InhousePartForm.html - lines 28-37 - added new min and max fields for the form - updated P tags with headers
OutsourcedPartForm.html - lines 41-49 - added validator
InhousePartForm.html - lines 41-49 - added validator

//////////
Part H
Created NotEnoughParts.html to display low part inventory when updating parts
Created NotEnoughParts.html to display low part inventory when updating products
InventoryValidator.java - lines 32-57 - Displays error message when inventory value is greater than max and min
//////////
Part I
PartTest.java - lines 160-187 - 2 unit tests were made to test the min and max fields

//////////
Part J