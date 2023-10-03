/* Generated By:JavaCC: Do not edit this line. Compilabob.java */
import java.io.*;
import java.util.ArrayList;

public class Compilabob implements CompilabobConstants {
        String errormsg="",datos = "";
        int sentencias_inco =0;
        //variebales para semantica-------------------------------
    String Type="", Valor=""; //variables cache para capturar el par
    String lugar = "";
        Token var;
    //--------------------------------------------------------
        public static void main(String args[])  {
                Compilabob compilador = new Compilabob(System.in);
                try {
                        compilador.Codigo();
                }catch( Exception e ){
                        System.out.println("\nEXCEPTION e MAIN\n" +"Sentencias incorrectas encontradas: "+compilador.sentencias_inco);
                }
                catch( TokenMgrError e ) {
                        System.out.println( "Error de Token" );
                }
                if(compilador.errormsg == "" && compilador.sentencias_inco == 0){
                        System.out.println("Compilador ejecutado con "+"\u00e9"+"xito");
                }else{
                        System.out.println(compilador.errormsg);
                }
                System.out.println("Sentencias incorrectas encontradas: "+compilador.sentencias_inco);
                System.out.println("----- Tabla hash ----"+ ClaseSemantica.tabla);
                for(int i = 0; i < Expresiones.tokensValue.size(); i++) {
            System.out.println(Expresiones.tokensValue.get(i).toString());
        }
        }

//------------------------------- ANÁLISIS SINTACTICO - AREA DE GRAMATICAS ----------------------------------------------------

// Gramatica inicial que contiene el cuerpo basico del codigo
  final public void Codigo() throws ParseException {
        ClaseSemantica.SetTables();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INICIO:
      jj_consume_token(INICIO);
      break;
    default:
      jj_la1[0] = jj_gen;
      ErrorNoinicio();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SepIzq:
      jj_consume_token(SepIzq);
      break;
    default:
      jj_la1[1] = jj_gen;
      ErrorNoSepINICIO();
    }
    Cuerpo();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SepDer:
      jj_consume_token(SepDer);
      break;
    default:
      jj_la1[2] = jj_gen;
      ErrorNoSepFINAL();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FIN:
      jj_consume_token(FIN);
      break;
    default:
      jj_la1[3] = jj_gen;
      ErrorNOFIN();
    }
    jj_consume_token(0);
  }

// método cuerpo, lee un conjunto de sentencias tamaño n
  final public void Cuerpo() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case CicloIterado:
      case CicloLimit:
      case ESCRIBIR:
      case PuntoComa:
      case ENTERO:
      case FLOTANTE:
      case ID_CADENA:
      case BOOLEANO:
      case IDENTIFICADOR:
      case UNKNOW:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_1;
      }
      sentencias();
    }
  }

// metodo sentencias, lee todas las gramaticas que pueden ser reconocidas por el compilador
  final public void sentencias() throws ParseException {
    try {
      if (jj_2_1(2)) {
        Declaracion();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFICADOR:
          Asignacion();
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case PuntoComa:
            jj_consume_token(PuntoComa);
            break;
          default:
            jj_la1[5] = jj_gen;
            errorFinlinea();
          }
          break;
        case CicloIterado:
          Ciclo_RepitoHastaQue();
          break;
        case CicloLimit:
          Ciclo_RepitoMientras();
          break;
        case IF:
          Decide();
          break;
        case ESCRIBIR:
          Muestra();
          break;
        case UNKNOW:
          error();
          break;
        case PuntoComa:
          errorDOBLElinea();
          break;
        default:
          jj_la1[6] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    } catch (ParseException e) {
        System.out.println(e.toString());  //imprime el mensaje de error
        System.out.println("ESTE ES EL TOKEN ALV "+token.kind);
    error_skipto(PuntoComa, FIN, EOF);
    }
  }

  final public void Muestra() throws ParseException {
    jj_consume_token(ESCRIBIR);
    jj_consume_token(ParenIzq);
    Mensaje();
    jj_consume_token(ParenDer);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PuntoComa:
      jj_consume_token(PuntoComa);
      break;
    default:
      jj_la1[7] = jj_gen;
      errorFinlinea();
    }
  }

  final public void Mensaje() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CADENAS:
    case IDENTIFICADOR:
      Concatenacion();
      break;
    default:
      jj_la1[8] = jj_gen;

    }
  }

  final public void Concatenacion() throws ParseException {
    if (jj_2_2(2)) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFICADOR:
        jj_consume_token(IDENTIFICADOR);
        break;
      case CADENAS:
        jj_consume_token(CADENAS);
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(MAS);
      Concatenacion();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CADENAS:
      case IDENTIFICADOR:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFICADOR:
          jj_consume_token(IDENTIFICADOR);
          break;
        case CADENAS:
          jj_consume_token(CADENAS);
          break;
        default:
          jj_la1[10] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

//########  DECIDE IF-ELSE ##########
  final public void Decide() throws ParseException {
    IF();
    if (jj_2_3(2)) {
      ELSE();
    } else {

    }
  }

  final public void IF() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(ParenIzq);
    OpComparacion();
    jj_consume_token(ParenDer);
    jj_consume_token(ASIGNACION);
    jj_consume_token(SepIzq);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case CicloIterado:
      case CicloLimit:
      case ESCRIBIR:
      case PuntoComa:
      case ENTERO:
      case FLOTANTE:
      case ID_CADENA:
      case BOOLEANO:
      case IDENTIFICADOR:
      case UNKNOW:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_2;
      }
      sentencias();
    }
    jj_consume_token(SepDer);
  }

  final public void ELSE() throws ParseException {
    jj_consume_token(ELSE);
    jj_consume_token(SepIzq);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case CicloIterado:
      case CicloLimit:
      case ESCRIBIR:
      case PuntoComa:
      case ENTERO:
      case FLOTANTE:
      case ID_CADENA:
      case BOOLEANO:
      case IDENTIFICADOR:
      case UNKNOW:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_3;
      }
      sentencias();
    }
    jj_consume_token(SepDer);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PuntoComa:
      jj_consume_token(PuntoComa);
      break;
    default:
      jj_la1[14] = jj_gen;
      errorFinlinea();
    }
  }

// ############## CICLOS #############
  final public void Ciclo_RepitoHastaQue() throws ParseException {
    jj_consume_token(CicloIterado);
    jj_consume_token(ParenIzq);
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(COMA);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
      jj_consume_token(IDENTIFICADOR);
      break;
    case NUMERO:
    case NUMDECIMAL:
    case CADENAS:
    case EST_LOGIC:
      DataType();
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(ParenDer);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASIGNACION:
      jj_consume_token(ASIGNACION);
      break;
    default:
      jj_la1[16] = jj_gen;
      ErrorNoAsignacion();
    }
    jj_consume_token(SepIzq);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case CicloIterado:
      case CicloLimit:
      case ESCRIBIR:
      case PuntoComa:
      case ENTERO:
      case FLOTANTE:
      case ID_CADENA:
      case BOOLEANO:
      case IDENTIFICADOR:
      case UNKNOW:
        ;
        break;
      default:
        jj_la1[17] = jj_gen;
        break label_4;
      }
      sentencias();
    }
    jj_consume_token(SepDer);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PuntoComa:
      jj_consume_token(PuntoComa);
      break;
    default:
      jj_la1[18] = jj_gen;
      errorFinlinea();
    }
  }

  final public void Ciclo_RepitoMientras() throws ParseException {
    jj_consume_token(CicloLimit);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASIGNACION:
      jj_consume_token(ASIGNACION);
      break;
    default:
      jj_la1[19] = jj_gen;
      ErrorNoAsignacion();
    }
    jj_consume_token(SepIzq);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case CicloIterado:
      case CicloLimit:
      case ESCRIBIR:
      case PuntoComa:
      case ENTERO:
      case FLOTANTE:
      case ID_CADENA:
      case BOOLEANO:
      case IDENTIFICADOR:
      case UNKNOW:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_5;
      }
      sentencias();
    }
    jj_consume_token(SepDer);
    jj_consume_token(CicloWhile);
    jj_consume_token(ParenIzq);
    OpComparacion();
    jj_consume_token(ParenDer);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PuntoComa:
      jj_consume_token(PuntoComa);
      break;
    default:
      jj_la1[21] = jj_gen;
      errorFinlinea();
    }
  }

// DECLARACION DE VARIABLES 
  final public void Declaracion() throws ParseException {
        int td;
    Variable_dato();
        td = token.kind;
    var = jj_consume_token(IDENTIFICADOR);
        if(ClaseSemantica.checkVariable(var).equals("")){
                errormsg = errormsg+"Error sem\u00e1ntico en la l\u00ednea " +var.beginLine +", columna "+var.beginColumn +", la variable "+ var.image + " ya  ha sido declarada \r\n";
                sentencias_inco++;
                Expresiones.tokensValue.remove((Expresiones.tokensValue.size()-1));
        }else{
                ClaseSemantica.InsertarSimbolo(var,td);
                System.out.println("Esta es la image "+token.image);
                Expresiones.tokensValue.add(token.image);
        }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASIGNACION:
      jj_consume_token(ASIGNACION);
                 Expresiones.tokensValue.add(token.image);
      AsignacionD();
      break;
    default:
      jj_la1[22] = jj_gen;

    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PuntoComa:
      jj_consume_token(PuntoComa);
                                                                                             Expresiones.tokensValue.add(token.image);
      break;
    default:
      jj_la1[23] = jj_gen;
      errorFinlinea();
    }
  }

// ASIGNACION DE VALORES DESPUES DE UNA DECLARACION
  final public void AsignacionD() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LEER:
      jj_consume_token(LEER);
                  Expresiones.tokensValue.add(token.image);
      break;
    case ParenIzq:
    case MENOS:
    case NUMERO:
    case NUMDECIMAL:
    case CADENAS:
    case EST_LOGIC:
    case IDENTIFICADOR:
      Expresion();
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// ASIGNACION GENERAL DE VALORES A UNA VARIABLE
  final public void Asignacion() throws ParseException {
        Token t2;
    var = jj_consume_token(IDENTIFICADOR);
        if(!(ClaseSemantica.checkVariable(var).equals(""))){
                errormsg = errormsg+ClaseSemantica.checkVariable(var);
                sentencias_inco++;
                Expresiones.tokensValue.remove((Expresiones.tokensValue.size()-1));
        }else{
                Expresiones.tokensValue.add(token.image);
        }
    jj_consume_token(ASIGNACION);
                  Expresiones.tokensValue.add(token.image);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LEER:
      jj_consume_token(LEER);
      break;
    case ParenIzq:
    case MENOS:
    case NUMERO:
    case NUMDECIMAL:
    case CADENAS:
    case EST_LOGIC:
    case IDENTIFICADOR:
      Expresion();
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                t2 = token;

                if(!(ClaseSemantica.checkAsing(var,t2).equals(" "))){
                        errormsg = errormsg+ClaseSemantica.checkAsing(var,t2);
                        sentencias_inco++;
                        Expresiones.tokensValue.remove((Expresiones.tokensValue.size()-1));
                }
  }

//###### GRAMATICA PARA EXPRESIONES MATEMATICAS DESPUES DE UNA ASIGNACION O DECLARACION
  final public void Expresion() throws ParseException {
    Termino();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAS:
      case MENOS:
        ;
        break;
      default:
        jj_la1[26] = jj_gen;
        break label_6;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAS:
        jj_consume_token(MAS);
        break;
      case MENOS:
        jj_consume_token(MENOS);
        break;
      default:
        jj_la1[27] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
                                   Expresiones.tokensValue.add(token.image);
      Termino();
    }
  }

// Epsilon  ---> | {}
  final public void Termino() throws ParseException {
    Factor();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIV:
      case MODULO:
      case MULTI:
        ;
        break;
      default:
        jj_la1[28] = jj_gen;
        break label_7;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTI:
        jj_consume_token(MULTI);
        break;
      case DIV:
        jj_consume_token(DIV);
        break;
      case MODULO:
        jj_consume_token(MODULO);
        break;
      default:
        jj_la1[29] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
                                           Expresiones.tokensValue.add(token.image);
      Factor();
    }
  }

  final public void Factor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MENOS:
      jj_consume_token(MENOS);
                 Expresiones.tokensValue.add(token.image);
      Factor();
      break;
    case ParenIzq:
    case NUMERO:
    case NUMDECIMAL:
    case CADENAS:
    case EST_LOGIC:
    case IDENTIFICADOR:
      Primario();
      break;
    default:
      jj_la1[30] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Primario() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ParenIzq:
      jj_consume_token(ParenIzq);
                     Expresiones.tokensValue.add(token.image);
      Expresion();
      jj_consume_token(ParenDer);
                                                                                       Expresiones.tokensValue.add(token.image);
      break;
    case NUMERO:
    case NUMDECIMAL:
    case CADENAS:
    case EST_LOGIC:
      DataType();
      break;
    case IDENTIFICADOR:
      jj_consume_token(IDENTIFICADOR);
                                                                                                                                                                    Expresiones.tokensValue.add(token.image);
      break;
    default:
      jj_la1[31] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// ############## OPERACIONES DE COMPARACION PARA IF O CICLOS  ####################
  final public void OpComparacion() throws ParseException {
    ExpresionL();
    Comparadores();
    ExpresionL();
  }

  final public void ExpresionL() throws ParseException {
    if (jj_2_4(2)) {
      FactorL();
      Logicos();
      ExpresionL();
    } else {
      FactorL();
    }
  }

  final public void FactorL() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMERO:
    case NUMDECIMAL:
    case CADENAS:
    case EST_LOGIC:
      DataType();
      break;
    default:
      jj_la1[33] = jj_gen;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFICADOR:
        jj_consume_token(IDENTIFICADOR);
                                         Expresiones.tokensValue.add(token.image);
        break;
      default:
        jj_la1[32] = jj_gen;
        errorNoIden();
      }
    }
  }

// Epsilon ---> | {}

// DATOS Y OPERADORES USADOS EN SENTENCIAS
  final public void DataType() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMERO:
      jj_consume_token(NUMERO);
      break;
    case NUMDECIMAL:
      jj_consume_token(NUMDECIMAL);
      break;
    case EST_LOGIC:
      jj_consume_token(EST_LOGIC);
      break;
    case CADENAS:
      jj_consume_token(CADENAS);
      break;
    default:
      jj_la1[34] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                                                   Expresiones.tokensValue.add(token.image);
  }

  final public void Comparadores() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MENOR:
      jj_consume_token(MENOR);
      break;
    case MAYOR:
      jj_consume_token(MAYOR);
      break;
    case MENOR_IGUAL:
      jj_consume_token(MENOR_IGUAL);
      break;
    case MAYOR_IGUAL:
      jj_consume_token(MAYOR_IGUAL);
      break;
    case IGUALDAD:
      jj_consume_token(IGUALDAD);
      break;
    case NOTEQ:
      jj_consume_token(NOTEQ);
      break;
    default:
      jj_la1[35] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          Expresiones.tokensValue.add(token.image);
  }

  final public void Logicos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OR:
      jj_consume_token(OR);
      break;
    case AND:
      jj_consume_token(AND);
      break;
    default:
      jj_la1[36] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
         Expresiones.tokensValue.add(token.image);
  }

  final public void Operadores() throws ParseException {
    if (jj_2_5(3)) {
      jj_consume_token(MAS);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MENOS:
        jj_consume_token(MENOS);
        break;
      case DIV:
        jj_consume_token(DIV);
        break;
      case MODULO:
        jj_consume_token(MODULO);
        break;
      case MULTI:
        jj_consume_token(MULTI);
        break;
      default:
        jj_la1[37] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void Variable_dato() throws ParseException {
    if (jj_2_6(3)) {
      jj_consume_token(ENTERO);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FLOTANTE:
        jj_consume_token(FLOTANTE);
        break;
      case ID_CADENA:
        jj_consume_token(ID_CADENA);
        break;
      case BOOLEANO:
        jj_consume_token(BOOLEANO);
        break;
      default:
        jj_la1[38] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  void error_skipto(int puntocoma, int fincode, int finfile) throws ParseException {
  Token t;
  sentencias_inco++;
  // consume tokens all the way up to a token of "kind" - use a do-while loop
  // rather than a while because the current token is the one immediately before
  // the erroneous token (in our case the token immediately before what should
  // have been "if"/"while".
  //, int sepiz   &&(t.kind !=sepiz)
  do {
        System.out.println("ESTE ES EL TOKEN ALV "+token.kind);
    t = getNextToken();
  }
  while ((t.kind !=puntocoma)&&(t.kind !=fincode)&&(t.kind !=finfile));
  }

  final public void error() throws ParseException {
        String errores = " ";
        Token t;
    t = jj_consume_token(UNKNOW);
        errores = "Simbolo: " + t.image + " no reconocido en la l\u00ednea "+String.valueOf(t.beginLine)+" columna "+String.valueOf(t.endColumn)+"\r\n";
        errormsg = errormsg+errores;
        sentencias_inco++;
  }

  final public void errorFinlinea() throws ParseException {
        sentencias_inco++;
        System.out.println("Error sint"+"\u00e1"+"ctico en la linea: "+token.beginLine+" Columna: "+(token.endColumn+1)+" falta ';'");

  }

  final public void errorDOBLElinea() throws ParseException {
        sentencias_inco++;
        System.out.println("Error sint"+"\u00e1"+"ctico en la linea: "+token.beginLine+" Columna: "+(token.endColumn+1)+" hay mas de un ';'  ");
    jj_consume_token(PuntoComa);
  }

//GRAMATICAS DE ERROR PARA LA ESTRUCTURA DEL CODIGO COATL
  final public void ErrorNoinicio() throws ParseException {
        sentencias_inco++;
        System.out.println("Error sint"+"\u00e1"+"ctico en la linea: "+getToken(1).beginLine+" Columna: "+getToken(1).endColumn+": No hay palabra de arranque \"compilar_coatl\" ");

  }

  final public void ErrorNoSepINICIO() throws ParseException {
        System.out.println("Error sint"+"\u00e1"+"ctico en la linea: "+getToken(1).beginLine+" Columna: "+getToken(1).beginColumn+" No hay llave izquierda \"{\" ");
        sentencias_inco++;

  }

  final public void ErrorNoSepFINAL() throws ParseException {
        sentencias_inco++;
        System.out.println("Error sint"+"\u00e1"+"ctico en la linea: "+token.beginLine+" Columna: "+token.beginColumn+": No hay llave derecha \"}\"");

  }

  final public void ErrorNOFIN() throws ParseException {
        sentencias_inco++;
        System.out.println("Error sint"+"\u00e1"+"ctico en la linea: "+token.beginLine+" Columna: "+token.beginColumn+" No hay palabra de cierre\"ejecutar_coatl\"" );

  }

  final public void ErrorNoAsignacion() throws ParseException {
        sentencias_inco++;
        System.out.println("Error sint"+"\u00e1"+"ctico en la linea: "+token.beginLine+" Columna: "+token.beginColumn+" Falta signo de asignaci\u00f3n \":\" " );

  }

  final public void errorNoIden() throws ParseException {
        sentencias_inco++;
        System.out.println("Error sint"+"\u00e1"+"ctico en la linea: "+token.beginLine+" Columna: "+token.beginColumn+" Se esperaba un \"<IDENTIFICADOR>\" " );

  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_3R_15() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(38)) {
    jj_scanpos = xsp;
    if (jj_scan_token(39)) {
    jj_scanpos = xsp;
    if (jj_scan_token(41)) {
    jj_scanpos = xsp;
    if (jj_scan_token(40)) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_10() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_13()) {
    jj_scanpos = xsp;
    if (jj_3R_14()) return true;
    }
    return false;
  }

  private boolean jj_3R_9() {
    if (jj_scan_token(ELSE)) return true;
    if (jj_scan_token(SepIzq)) return true;
    return false;
  }

  private boolean jj_3R_8() {
    if (jj_3R_12()) return true;
    if (jj_scan_token(IDENTIFICADOR)) return true;
    return false;
  }

  private boolean jj_3_2() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(42)) {
    jj_scanpos = xsp;
    if (jj_scan_token(40)) return true;
    }
    if (jj_scan_token(MAS)) return true;
    return false;
  }

  private boolean jj_3R_16() {
    if (jj_scan_token(IDENTIFICADOR)) return true;
    return false;
  }

  private boolean jj_3R_12() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_6()) {
    jj_scanpos = xsp;
    if (jj_scan_token(35)) {
    jj_scanpos = xsp;
    if (jj_scan_token(36)) {
    jj_scanpos = xsp;
    if (jj_scan_token(37)) return true;
    }
    }
    }
    return false;
  }

  private boolean jj_3R_11() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(25)) {
    jj_scanpos = xsp;
    if (jj_scan_token(26)) return true;
    }
    return false;
  }

  private boolean jj_3_6() {
    if (jj_scan_token(ENTERO)) return true;
    return false;
  }

  private boolean jj_3R_14() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_3R_17()) return true;
    }
    return false;
  }

  private boolean jj_3_4() {
    if (jj_3R_10()) return true;
    if (jj_3R_11()) return true;
    return false;
  }

  private boolean jj_3R_18() {
    return false;
  }

  private boolean jj_3R_17() {
    if (jj_3R_18()) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_3R_9()) return true;
    return false;
  }

  private boolean jj_3_5() {
    if (jj_scan_token(MAS)) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_8()) return true;
    return false;
  }

  private boolean jj_3R_13() {
    if (jj_3R_15()) return true;
    return false;
  }

  /** Generated Token Manager. */
  public CompilabobTokenManager token_source;
  JavaCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  /** Whether we are looking ahead. */
  private boolean jj_lookingAhead = false;
  private boolean jj_semLA;
  private int jj_gen;
  final private int[] jj_la1 = new int[39];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x10,0x8000,0x10000,0x20,0x20b40,0x20000,0x20b40,0x20000,0x0,0x0,0x0,0x0,0x20b40,0x20b40,0x20000,0x0,0x80000,0x20b40,0x20000,0x80000,0x20b40,0x20000,0x80000,0x20000,0x40003000,0x40003000,0x60000000,0x60000000,0x80000000,0x80000000,0x40002000,0x2000,0x0,0x0,0x0,0x9f00000,0x6000000,0xc0000000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0xc3c,0x0,0xc00,0x0,0x500,0x500,0x500,0x500,0xc3c,0xc3c,0x0,0x7c0,0x0,0xc3c,0x0,0x0,0xc3c,0x0,0x0,0x0,0x7c0,0x7c0,0x0,0x0,0x3,0x3,0x7c0,0x7c0,0x400,0x3c0,0x3c0,0x0,0x0,0x3,0x38,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[6];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Compilabob(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Compilabob(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CompilabobTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Compilabob(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new CompilabobTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Compilabob(CompilabobTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(CompilabobTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = jj_lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List jj_expentries = new java.util.ArrayList();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Iterator it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          exists = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.add(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[44];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 39; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 44; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 6; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
