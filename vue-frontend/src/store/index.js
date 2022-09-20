import { createStore } from 'vuex'
import {secureState} from "@/store/secureState";

export default createStore({
  modules: {
    secureState: secureState,
  }
})
