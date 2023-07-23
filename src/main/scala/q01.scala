object q01 extends App{
  var shift=1

  def cipherEncrypt(str:String):String={
    var res=""
    for (c<-str){
      c match{
        case x if !x.isLetter => res=res+x
        case x if x.isUpper => res=res+((((x-65+shift)%26)+65).toChar)
        case x if x.isLower => res=res+((((x-97+shift)%26)+97).toChar)
      }
    }
    res
  }

  def cipherDecrypt(str:String):String={
    var res = ""
    for (c <- str) {
      c match{
        case x if !x.isLetter => res=res+x
        case x if x.isUpper => {
            if(x-65 - shift<0)res = res + ((((x - 65 - shift)) + 91).toChar)
            else res = res + ((x- shift).toChar)
          }
        case x if x.isLower => {
            if (x - 97 - shift < 0) res = res + ((((x - 97 - shift)) + 122).toChar)
            else res = res + ((x - shift).toChar)
          }
      }
    }
    res
  }

  def cipherMethod(str:String)(Func:String):Unit={
    if(Func=="Encrypt"){
      println("Encrypted Message for \""+str+"\" is => "+cipherEncrypt(str))
    }else if (Func == "Decrypt") {
      println("Decrypted Message of \"" + str + "\" is => " + cipherDecrypt(str))
    }
    else {
      println("Invalid func")
    }
  }

  cipherMethod("Chathura Lakshan is 22 years old!")("Encrypt")
  cipherMethod("Dibuivsb Mbltibo jt 22 zfbst pme!")("Decrypt")

}