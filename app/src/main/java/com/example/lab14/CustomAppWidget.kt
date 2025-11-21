package com.example.lab14

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

/**
 * Receptor de la AppWidget para el Widget Personalizado.
 * Simplemente vincula el receptor con el contenido Glance.
 */
class CustomAppWidget : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = CustomWidgetContent()
}