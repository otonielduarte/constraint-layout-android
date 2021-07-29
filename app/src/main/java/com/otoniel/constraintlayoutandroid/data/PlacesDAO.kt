package com.otoniel.constraintlayoutandroid.data

import com.otoniel.constraintlayoutandroid.model.Model
import java.math.BigDecimal
import kotlin.collections.ArrayList


class PlacesDAO {
    fun list(): ArrayList<Model> {
        return ArrayList<Model>(
            listOf(
                Model("São Paulo", "sao_paulo_sp", 2, BigDecimal(243.99)),
                Model("Belo Horizonte", "belo_horizonte_mg", 3, BigDecimal(421.50)),
                Model("Recife", "recife_pe", 4, BigDecimal(754.20)),
                Model("Rio de Janeiro", "rio_de_janeiro_rj", 6, BigDecimal(532.55)),
                Model("Salvador", "salvador_ba", 5, BigDecimal(899.99)),
                Model("Foz do Iguaçu", "foz_do_iguacu_pr", 1, BigDecimal(289.90))
            )
        )
    }
}