package com.bigbratan.emulair.fragments.pauseMenuActions

import android.content.Context
import com.bigbratan.emulair.common.metadata.retrograde.ExposedSetting
import java.io.Serializable

data class EmulairCoreOption(
    private val exposedSetting: ExposedSetting,
    private val coreOption: CoreOption
) : Serializable {

    fun getKey(): String {
        return exposedSetting.key
    }

    fun getDisplayName(context: Context): String {
        return context.getString(exposedSetting.titleId)
    }

    fun getEntries(context: Context): List<String> {
        if (exposedSetting.values.isEmpty()) {
            return coreOption.optionValues.map { it.capitalize() }
        }

        return getCorrectExposedSettings().map { context.getString(it.titleId) }
    }

    fun getEntriesValues(): List<String> {
        if (exposedSetting.values.isEmpty()) {
            return coreOption.optionValues.map { it }
        }

        return getCorrectExposedSettings().map { it.key }
    }

    fun getCurrentValue(): String {
        return coreOption.variable.value
    }

    fun getCurrentIndex(): Int {
        return maxOf(getEntriesValues().indexOf(getCurrentValue()), 0)
    }

    private fun getCorrectExposedSettings(): List<ExposedSetting.Value> {
        return exposedSetting.values
            .filter { it.key in coreOption.optionValues }
    }
}
