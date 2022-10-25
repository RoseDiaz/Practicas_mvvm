package com.example.mvvm_ra.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class MainActivityModel :ViewModel() {


    private val _nombre = mutableStateOf("")
    val nombre:State<String> = _nombre

    private val _marca = mutableStateOf("")
    val marca:State<String> = _marca

    private val _valor = mutableStateOf(0.0)
    val valor:State<Double> = _valor


    private val _HondaAccord = mutableStateOf(678026.22)
    val HondaAccord:State<Double> = _HondaAccord
    private val _VwTouareg = mutableStateOf(879266.15)
    val VwTouareg:State<Double> = _VwTouareg
    private val _BMWX5 = mutableStateOf(1025366.87)
    val BMWX5:State<Double> = _BMWX5
    private val _MazdaCX7 = mutableStateOf(988641.02)
    val MazdaCX7:State<Double> = _MazdaCX7

    private val _porcentaje = mutableStateOf(0)
    val porcentaje:State<Int> = _porcentaje

    private val _enganche = mutableStateOf(0.0)
    val enganche:State<Double> = _enganche

    private val _P60 = mutableStateOf(60)
    val P60:State<Int> = _P60
    private val _P40 = mutableStateOf(40)
    val P40:State<Int> = _P40
    private val _P20 = mutableStateOf(20)
    val P20:State<Int> = _P20

    //Financiamiento
    private val _financiamiento = mutableStateOf(0.0)
    val financiamiento:State<Double> = _financiamiento
    private val _anios = mutableStateOf(0)
    val anios:State<Int> = _anios
    private val _plazo = mutableStateOf("")
    val plazo:State<String> = _plazo
    private val _interes = mutableStateOf(0.0)
    val interes:State<Double> = _interes
    private val _tasa = mutableStateOf(0.0)
    private val _total = mutableStateOf(0.0)
    val total:State<Double> = _total
    private val _meses = mutableStateOf(0)
    private val _pagomensual = mutableStateOf(0.0)
    val pagomensual:State<Double> = _pagomensual

    fun obtenerMarca(index:Int){
        when (index) {
            0 -> obtenerHonda()
            1 -> obtenerVw()
            2 -> obtenerBMW()
            3 -> obtenerMazda()
            else -> {
                print("")
            }
        }
    }

    fun obtenerPorcentaje(index:Int){
        when (index) {
            0 -> obtener20()
            1 -> obtener40()
            2 -> obtener60()
            else -> {
                print("")
            }
        }
    }

    fun obtenerFinanciamiento(index: Int){
        when (index) {
            0 -> obnenerUnAño()
            1 -> obnenerDosAños()
            2 -> obnenerTresAños()
            3 -> obnenerCuatroAños()
            4 -> obnenerCincoAños()

            else -> {
                print("")
            }
        }
    }

    fun obtenerHonda(){
        _marca.value = "Honda Accord $ ${ _HondaAccord.value.toString() }"
        _valor.value = _HondaAccord.value
    }
    fun obtenerVw(){
        _marca.value = "Vw Touareg $ ${_VwTouareg.value.toString()}"
        _valor.value = _VwTouareg.value
    }
    fun obtenerBMW(){
        _marca.value = "BMW X5 $ ${_BMWX5.value.toString()}"
        _valor.value = _BMWX5.value
    }
    fun obtenerMazda(){
        _marca.value = "Mazda CX7 $ ${ _MazdaCX7.value.toString() }"
        _valor.value = _MazdaCX7.value
    }

    fun obtener20(){
        _porcentaje.value = _P20.value
        calcularEnganche(_porcentaje.value,_valor.value)
    }
    fun obtener40(){
        _porcentaje.value = _P40.value
        calcularEnganche(_porcentaje.value,_valor.value)
    }
    fun obtener60(){
        _porcentaje.value = _P60.value
        calcularEnganche(_porcentaje.value,_valor.value)
    }

    fun calcularEnganche(porcentaje:Int,valor:Double){
        _enganche.value = porcentaje * valor / 100
        _enganche.value = String.format("%.2f", _enganche.value).toDouble()
        calcularFinanciamiento(_valor.value,_enganche.value)

    }
    fun obtenerNombre(nombre:String){
        _nombre.value = nombre
    }
    fun calcularFinanciamiento(valor: Double, enganche:Double){
        _financiamiento.value = valor - enganche
        _financiamiento.value = String.format("%.2f", _financiamiento.value).toDouble()

    }
    fun calcularInteres(tasa:Double,financiamiento:Double, anios:Int){
        _interes.value = tasa * financiamiento / 100 * anios
        _interes.value = String.format("%.2f", _interes.value).toDouble()
        calcularTotal()
    }
    fun calcularTotal(){
        _total.value = _financiamiento.value + _interes.value
        _total.value = String.format("%.2f", _total.value).toDouble()
        _pagomensual.value = _total.value / _meses.value
        _pagomensual.value = String.format("%.2f", _pagomensual.value).toDouble()

    }
    fun obnenerUnAño(){
        _plazo.value = "1 año, tasa 7.5%"
        _anios.value = 1
        _tasa.value = 7.5
        _meses.value = 12
        calcularInteres(_tasa.value,_financiamiento.value,_anios.value)

    }
    fun obnenerDosAños(){
        _plazo.value = "2 años, tasa 9.5%"
        _anios.value = 2
        _tasa.value = 9.5
        _meses.value = 24
        calcularInteres(_tasa.value,_financiamiento.value,_anios.value)

    }
    fun obnenerTresAños(){
        _plazo.value = "3 años, tasa 10.3%"
        _anios.value = 3
        _tasa.value = 10.3
        _meses.value = 36
        calcularInteres(_tasa.value,_financiamiento.value,_anios.value)

    }
    fun obnenerCuatroAños(){
        _plazo.value = "4 años, tasa 12.6%"
        _anios.value = 4
        _tasa.value = 12.6
        _meses.value = 48
        calcularInteres(_tasa.value,_financiamiento.value,_anios.value)

    }
    fun obnenerCincoAños(){
        _plazo.value = "5 años, tasa 13.5%"
        _anios.value = 5
        _tasa.value = 13.5
        _meses.value = 60
        calcularInteres(_tasa.value,_financiamiento.value,_anios.value)

    }








}






