package com.nocdib.affirmations.data

import android.R.drawable
import android.content.res.Resources
import android.util.Log
import com.nocdib.affirmations.R
import com.nocdib.affirmations.model.Affirmation
import java.lang.reflect.Field
import java.security.AccessController.getContext


class Datasource {

    fun loadAffirmations(): List<Affirmation> {
        val affirmationsList = listOf<Affirmation>(
            Affirmation(R.string.affirmation01),
            Affirmation(R.string.affirmation02),
            Affirmation(R.string.affirmation03),
            Affirmation(R.string.affirmation04),
            Affirmation(R.string.affirmation05),
            Affirmation(R.string.affirmation06),
            Affirmation(R.string.affirmation07),
            Affirmation(R.string.affirmation08),
            Affirmation(R.string.affirmation09),
            Affirmation(R.string.affirmation10)
        )

    return affirmationsList

    }
}