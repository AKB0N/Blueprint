/*
 * Copyright (c) 2017. Jahir Fiquitiva
 *
 * Licensed under the CreativeCommons Attribution-ShareAlike
 * 4.0 International License. You may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *    http://creativecommons.org/licenses/by-sa/4.0/legalcode
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Special thanks to the project contributors and collaborators
 * 	https://github.com/jahirfiquitiva/IkoniK#special-thanks
 */

package jahirfiquitiva.libs.ikonik.activities.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import jahirfiquitiva.libs.ikonik.utils.themes.ThemeUtils

open class ThemedActivity:AppCompatActivity() {
    var lastTheme = 0
    var coloredNavbar = false

    override fun onCreate(savedInstanceState:Bundle?) {
        ThemeUtils.setThemeTo(this)
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun onResume() {
        super.onResume()
        if (lastTheme != ThemeUtils.getCurrentTheme() ||
            coloredNavbar != ThemeUtils.hasColoredNavbar())
            ThemeUtils.restartActivity(this)
    }

    override fun onPostCreate(savedInstanceState:Bundle?) {
        super.onPostCreate(savedInstanceState)
        lastTheme = ThemeUtils.getCurrentTheme()
        coloredNavbar = ThemeUtils.hasColoredNavbar()
    }

}