/**
  * Created by Ben Chung on 3/21/2017.
  */
sealed trait Type { }
case class Any() extends Type {}
case class ClassT(name: String) extends Type {}

sealed trait Expr { }
case class Variable(name : String) extends Expr {}
case class This() extends Expr {}
case class That() extends Expr {}
case class New(className : String, values : List[Expr]) extends Expr {}
case class GetField(receiver: Expr, name : String) extends Expr {}
case class SetField(receiver: Expr, name : String, value : Expr) extends Expr {}
case class Call(receiver: Expr, method : String, argT : Type, resT : Type, arg : Expr) extends Expr {}
case class DynCall(receiver: Expr, method: String, arg: Expr) extends Expr {}
case class SubCast(tpe: Type, receiver: Expr) extends Expr {}
case class Sequence(exprs : List[Expr]) extends Expr {}

sealed trait Md {}
case class MethodDef(name:String, variable: String, varType: Type, retType: Type, body:Expr) extends Md {}
case class SetterDef(name:String, variable: String, fieldType: Type, body:Expr) extends Md {}
case class GetterDef(name:String, fieldType: Type, body:Expr) extends Md {}

sealed trait Fd {}
case class FieldDef(name:String, fieldType:Type) extends Fd {}

sealed class Class(name: String, methods: List[Md], fields: List[Fd]) {}
