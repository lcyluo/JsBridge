package com.cisdi.qingzhu.jsbridge

import java.util.*

class Bridge private constructor() {

    private val mMessageHandlers: MutableMap<String, BridgeHandler> = HashMap()

    fun getMessageHandlers(): Map<String, BridgeHandler> {
        return mMessageHandlers
    }

    fun registerHandler(handlerName: String, handler: BridgeHandler?) {
        if (handler != null) {
            mMessageHandlers[handlerName] = handler
        }
    }

    fun registerHandler(handlers: Map<String, BridgeHandler>?) {
        if (handlers != null) {
            mMessageHandlers.putAll(handlers)
        }
    }

    fun unregisterHandler(handlerName: String?) {
        if (handlerName != null) {
            mMessageHandlers.remove(handlerName)
        }
    }

    companion object {
        @JvmStatic
        val instance = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder = Bridge()
    }

}
