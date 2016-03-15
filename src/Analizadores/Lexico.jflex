package Analizadores;

import java_cup.runtime.*;
import java_cup.runtime.Symbol;
import java.util.ArrayList;


%%

%{
   
%}


%public
%class Lexico
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode


digito = [0-9]
numero = {digito}+("." {digito}+)?
letra = [a-zA-ZñÑ]
id = {letra}+({letra}|{digito}|"_")*
correo = {id}"@"{id} "." "com"
cadenastring =(\"[^\"]*\")|(\"[^\"]*\"(\"[^\"]*\")*)



%state COMENT_SIMPLE

%state COMENT_MULTI

%%

<YYINITIAL> "/*"            {yybegin(COMENT_MULTI);}
<COMENT_MULTI> ["\n"]       {}
<COMENT_MULTI> [^"*/"]      {}
<COMENT_MULTI> "*/"         {yybegin(YYINITIAL);}

<YYINITIAL> "//"            {yybegin(COMENT_SIMPLE);}
<COMENT_SIMPLE> [^"\n"]     {}
<COMENT_SIMPLE> "\n"        {yybegin(YYINITIAL);}


/*posibles caracteres que pueden aparecer en mi archivo*/

<YYINITIAL> "$"                        {   System.out.println("Reconocido: "+yytext()+", dolar");
                                       return new Symbol(Simbolos.dolar, yycolumn, yyline, yytext());}

<YYINITIAL> "Rq"                       {   System.out.println("Reconocido: "+yytext()+", raiz");
                                       return new Symbol(Simbolos.rq, yycolumn, yyline, yytext());}

<YYINITIAL> "tipo"                     {   System.out.println("Reconocido: "+yytext()+", tipo");
                                       return new Symbol(Simbolos.tiptip, yycolumn, yyline, yytext());}


<YYINITIAL> "Ptn"                      {   System.out.println("Reconocido: "+yytext()+", potencia");
                                       return new Symbol(Simbolos.ptn, yycolumn, yyline, yytext());}

<YYINITIAL> "codigo"                   {   System.out.println("Reconocido: "+yytext()+", codigo");
                                       return new Symbol(Simbolos.codcod, yycolumn, yyline, yytext());}

<YYINITIAL> "nombre"                   {   System.out.println("Reconocido: "+yytext()+", nombre");
                                       return new Symbol(Simbolos.nomnom, yycolumn, yyline, yytext());}

<YYINITIAL> "telefono"                 {   System.out.println("Reconocido: "+yytext()+", telefono");
                                       return new Symbol(Simbolos.teltel, yycolumn, yyline, yytext());}

<YYINITIAL> "direccion"                {   System.out.println("Reconocido: "+yytext()+", direccion");
                                       return new Symbol(Simbolos.dirdir, yycolumn, yyline, yytext());}

<YYINITIAL> "sucursal"                 {   System.out.println("Reconocido: "+yytext()+", sucursal");
                                       return new Symbol(Simbolos.sucursucur, yycolumn, yyline, yytext());}

<YYINITIAL> "cantidad"                 {   System.out.println("Reconocido: "+yytext()+", cantidad");
                                       return new Symbol(Simbolos.cantcant, yycolumn, yyline, yytext());}
 
<YYINITIAL> "propietario"              {   System.out.println("Reconocido: "+yytext()+", propietario");
                                       return new Symbol(Simbolos.propipropi, yycolumn, yyline, yytext());}

<YYINITIAL> "Cons"                     {   System.out.println("Reconocido: "+yytext()+", cons");
                                       return new Symbol(Simbolos.cons, yycolumn, yyline, yytext());}

<YYINITIAL> "-"                        {   System.out.println("Reconocido: "+yytext()+", menor");
                                       return new Symbol(Simbolos.menor, yycolumn, yyline, yytext());}

<YYINITIAL> "@"                        {   System.out.println("Reconocido: "+yytext()+", @");
                                       return new Symbol(Simbolos.arroba, yycolumn, yyline, yytext());}

<YYINITIAL> "."                        {   System.out.println("Reconocido: "+yytext()+", punto");
                                       return new Symbol(Simbolos.punto, yycolumn, yyline, yytext());}

<YYINITIAL> \"                         {   System.out.println("Reconocido: "+yytext()+", comillas");
                                       return new Symbol(Simbolos.comillas, yycolumn, yyline, yytext());}

<YYINITIAL> "="                        {   System.out.println("Reconocido: "+yytext()+", igual");
                                       return new Symbol(Simbolos.igual, yycolumn, yyline, yytext());}

<YYINITIAL> ","                        {   System.out.println("Reconocido: "+yytext()+", coma");
                                       return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());}

<YYINITIAL> ";"                        {   System.out.println("Reconocido: "+yytext()+", puntoycoma");
                                       return new Symbol(Simbolos.ptcoma, yycolumn, yyline, yytext());}

<YYINITIAL> "+"                        {   System.out.println("Reconocido: "+yytext()+", mas");
                                       return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());}

<YYINITIAL> "*"                        {   System.out.println("Reconocido: "+yytext()+", por");
                                       return new Symbol(Simbolos.por, yycolumn, yyline, yytext());}

<YYINITIAL> "/"                        {   System.out.println("Reconocido: "+yytext()+", division");
                                       return new Symbol(Simbolos.division, yycolumn, yyline, yytext());}

<YYINITIAL> "{"                        {   System.out.println("Reconocido: "+yytext()+", llave");
                                       return new Symbol(Simbolos.illave, yycolumn, yyline, yytext());}

<YYINITIAL> "}"                        {   System.out.println("Reconocido: "+yytext()+", llave");
                                       return new Symbol(Simbolos.fllave, yycolumn, yyline, yytext());}

<YYINITIAL> "["                        {   System.out.println("Reconocido: "+yytext()+", llave");
                                       return new Symbol(Simbolos.icor, yycolumn, yyline, yytext());}

<YYINITIAL> "]"                        {   System.out.println("Reconocido: "+yytext()+", llave");
                                       return new Symbol(Simbolos.fcor, yycolumn, yyline, yytext());}

<YYINITIAL> "("                        {   System.out.println("Reconocido: "+yytext()+", parentesis");
                                       return new Symbol(Simbolos.apar, yycolumn, yyline, yytext());}

<YYINITIAL> ")"                        {   System.out.println("Reconocido: "+yytext()+", parentesis");
                                       return new Symbol(Simbolos.cpar, yycolumn, yyline, yytext());}


<YYINITIAL> "$request$"                {   System.out.println("Reconocido: "+yytext()+", $request$");
                                           return new Symbol(Simbolos.irequest, yycolumn, yyline, yytext());}

<YYINITIAL> "$request-$"               {   System.out.println("Reconocido: "+yytext()+", $request-$");
                                           return new Symbol(Simbolos.frequest, yycolumn, yyline, yytext());}

<YYINITIAL> "$InicioUsuario$"          {   System.out.println("Reconocido: "+yytext()+", $InicioUsuario$");
                                           return new Symbol(Simbolos.iusuario, yycolumn, yyline, yytext());}

<YYINITIAL> "$InicioUsuario-$"         {   System.out.println("Reconocido: "+yytext()+", $InicioUsuario-$");
                                           return new Symbol(Simbolos.fusuario, yycolumn, yyline, yytext());}

<YYINITIAL> "$id$"                     {   System.out.println("Reconocido: "+yytext()+", $id$");
                                           return new Symbol(Simbolos.iid, yycolumn, yyline, yytext());}

<YYINITIAL> "$id-$"                    {   System.out.println("Reconocido: "+yytext()+", $id-$");
                                           return new Symbol(Simbolos.fid, yycolumn, yyline, yytext());}

<YYINITIAL> "$password$"               {   System.out.println("Reconocido: "+yytext()+", $password$");
                                           return new Symbol(Simbolos.ipass, yycolumn, yyline, yytext());}

<YYINITIAL> "$password-$"              {   System.out.println("Reconocido: "+yytext()+", $password-$");
                                           return new Symbol(Simbolos.fpass, yycolumn, yyline, yytext());}

<YYINITIAL> "$CrearUsuario$"           {   System.out.println("Reconocido: "+yytext()+", $CrearUsuario$");
                                           return new Symbol(Simbolos.icrearusuario, yycolumn, yyline, yytext());}

<YYINITIAL> "$CrearUsuario-$"          {   System.out.println("Reconocido: "+yytext()+", $CrearUsuario-$");
                                           return new Symbol(Simbolos.fcrearusuario, yycolumn, yyline, yytext());}

<YYINITIAL> "$nombre$"                 {   System.out.println("Reconocido: "+yytext()+", $nombre$");
                                           return new Symbol(Simbolos.inombre, yycolumn, yyline, yytext());}

<YYINITIAL> "$nombre-$"                {   System.out.println("Reconocido: "+yytext()+", $nombre-$");
                                           return new Symbol(Simbolos.fnombre, yycolumn, yyline, yytext());}

<YYINITIAL> "$apellido$"               {   System.out.println("Reconocido: "+yytext()+", $apellido$");
                                           return new Symbol(Simbolos.iapellido, yycolumn, yyline, yytext());}

<YYINITIAL> "$apellido-$"              {   System.out.println("Reconocido: "+yytext()+", $apellido-$");
                                           return new Symbol(Simbolos.fapellido, yycolumn, yyline, yytext());}

<YYINITIAL> "$telefono$"               {   System.out.println("Reconocido: "+yytext()+", $telefono$");
                                           return new Symbol(Simbolos.itelefono, yycolumn, yyline, yytext());}

<YYINITIAL> "$telefono-$"              {   System.out.println("Reconocido: "+yytext()+", $telefono-$");
                                           return new Symbol(Simbolos.ftelefono, yycolumn, yyline, yytext());}

<YYINITIAL> "$email$"                  {   System.out.println("Reconocido: "+yytext()+", $email$");
                                           return new Symbol(Simbolos.iemail, yycolumn, yyline, yytext());}

<YYINITIAL> "$email-$"                 {   System.out.println("Reconocido: "+yytext()+", $email-$");
                                           return new Symbol(Simbolos.femail, yycolumn, yyline, yytext());}

<YYINITIAL> "$direccion$"              {   System.out.println("Reconocido: "+yytext()+", $direccion$");
                                           return new Symbol(Simbolos.idireccion, yycolumn, yyline, yytext());}

<YYINITIAL> "$direccion-$"             {   System.out.println("Reconocido: "+yytext()+", $direccion-$");
                                           return new Symbol(Simbolos.fdireccion, yycolumn, yyline, yytext());}

<YYINITIAL> "$tienda"                  {   System.out.println("Reconocido: "+yytext()+", tienda");
                                           return new Symbol(Simbolos.itienda, yycolumn, yyline, yytext());}

<YYINITIAL> "$tienda-$"                {   System.out.println("Reconocido: "+yytext()+", fin tienda");
                                           return new Symbol(Simbolos.ftienda, yycolumn, yyline, yytext());}

<YYINITIAL> "$codigo$"                 {   System.out.println("Reconocido: "+yytext()+", codigo");
                                           return new Symbol(Simbolos.icodigo, yycolumn, yyline, yytext());}

<YYINITIAL> "$codigo-$"                {   System.out.println("Reconocido: "+yytext()+", fin codigo");
                                           return new Symbol(Simbolos.fcodigo, yycolumn, yyline, yytext());}

<YYINITIAL> "$propietario$"            {   System.out.println("Reconocido: "+yytext()+", propietario");
                                           return new Symbol(Simbolos.ipropietario, yycolumn, yyline, yytext());}

<YYINITIAL> "$propietario-$"           {   System.out.println("Reconocido: "+yytext()+", fin propietario");
                                           return new Symbol(Simbolos.fpropietario, yycolumn, yyline, yytext());}

<YYINITIAL> "$img$"                    {   System.out.println("Reconocido: "+yytext()+", imagen");
                                           return new Symbol(Simbolos.iimg, yycolumn, yyline, yytext());}

<YYINITIAL> "$img-$"                   {   System.out.println("Reconocido: "+yytext()+", fin imagen");
                                           return new Symbol(Simbolos.fimg, yycolumn, yyline, yytext());}

<YYINITIAL> "$cantidad$"               {   System.out.println("Reconocido: "+yytext()+", cantidad");
                                           return new Symbol(Simbolos.icantidad, yycolumn, yyline, yytext());}

<YYINITIAL> "$cantidad-$"              {   System.out.println("Reconocido: "+yytext()+", fin cantidad");
                                           return new Symbol(Simbolos.fcantidad, yycolumn, yyline, yytext());}

<YYINITIAL> "$marca$"                  {   System.out.println("Reconocido: "+yytext()+", marca");
                                           return new Symbol(Simbolos.imarca, yycolumn, yyline, yytext());}

<YYINITIAL> "$marca-$"                 {   System.out.println("Reconocido: "+yytext()+", fin marca");
                                           return new Symbol(Simbolos.fmarca, yycolumn, yyline, yytext());}

<YYINITIAL> "$color$"                  {   System.out.println("Reconocido: "+yytext()+", color");
                                           return new Symbol(Simbolos.icolor, yycolumn, yyline, yytext());}

<YYINITIAL> "$color-$"                 {   System.out.println("Reconocido: "+yytext()+", fin color");
                                           return new Symbol(Simbolos.fcolor, yycolumn, yyline, yytext());}

<YYINITIAL> "$tamaño$"                 {   System.out.println("Reconocido: "+yytext()+", tamaño");
                                           return new Symbol(Simbolos.itam, yycolumn, yyline, yytext());}

<YYINITIAL> "$tamaño-$"                {   System.out.println("Reconocido: "+yytext()+", fin tamaño");
                                           return new Symbol(Simbolos.ftam, yycolumn, yyline, yytext());}

<YYINITIAL> "$sucursal$"               {   System.out.println("Reconocido: "+yytext()+", sucursal");
                                           return new Symbol(Simbolos.isucursal, yycolumn, yyline, yytext());}

<YYINITIAL> "$sucursal-$"              {   System.out.println("Reconocido: "+yytext()+", fin sucursal");
                                           return new Symbol(Simbolos.fsucursal, yycolumn, yyline, yytext());}

<YYINITIAL> "$producto"                {   System.out.println("Reconocido: "+yytext()+", producto");
                                           return new Symbol(Simbolos.iproducto, yycolumn, yyline, yytext());}

<YYINITIAL> "$producto-$"              {   System.out.println("Reconocido: "+yytext()+", fin producto");
                                           return new Symbol(Simbolos.fproducto, yycolumn, yyline, yytext());}

<YYINITIAL> "$mate"                    {   System.out.println("Reconocido: "+yytext()+", mate");
                                           return new Symbol(Simbolos.imate, yycolumn, yyline, yytext());}

<YYINITIAL> "$mate-$"                  {   System.out.println("Reconocido: "+yytext()+", fin mate");
                                           return new Symbol(Simbolos.fmate, yycolumn, yyline, yytext());}



<YYINITIAL> {numero}                   {   System.out.println("Reconocido: "+yytext()+", numero ");
                                           return new Symbol(Simbolos.numero, yycolumn, yyline, yytext());}

<YYINITIAL> {id}                       {   System.out.println("Reconocido: "+yytext()+", id ");
                                           return new Symbol(Simbolos.id, yycolumn, yyline, yytext());}

<YYINITIAL> {correo}                   {   System.out.println("Reconocido: "+yytext()+", correo ");
                                           return new Symbol(Simbolos.correo, yycolumn, yyline, yytext());}

<YYINITIAL> {cadenastring}             {   System.out.println("Reconocido: "+yytext()+", cadena ");
                                           return new Symbol(Simbolos.cadenastring, yycolumn, yyline, yytext());}



[ \t\r\n\f]                            {/* ignore white space. */ }

.                                      {   System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");}
                                           