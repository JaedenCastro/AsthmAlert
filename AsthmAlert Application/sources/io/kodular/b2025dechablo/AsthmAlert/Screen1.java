package io.kodular.b2025dechablo.AsthmAlert;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.appinventor.components.common.ComponentConstants;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.BluetoothClient;
import com.google.appinventor.components.runtime.Clock;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Decoration;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Image;
import com.google.appinventor.components.runtime.KodularBottomNavigation;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.ListView;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.Sound;
import com.google.appinventor.components.runtime.SpaceView;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;
import com.google.appinventor.components.runtime.errors.PermissionException;
import com.google.appinventor.components.runtime.errors.StopBlocksExecution;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.FullScreenVideoUtil;
import com.google.appinventor.components.runtime.util.RetValManager;
import com.google.appinventor.components.runtime.util.RuntimeErrorAlert;
import com.google.youngandroid.runtime;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.Promise;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.require;
import org.jose4j.jws.AlgorithmIdentifiers;

/* compiled from: Screen1.yail */
public class Screen1 extends Form implements Runnable {
    static final SimpleSymbol Lit0 = ((SimpleSymbol) new SimpleSymbol("Screen1").readResolve());
    static final SimpleSymbol Lit1 = ((SimpleSymbol) new SimpleSymbol("getMessage").readResolve());
    static final SimpleSymbol Lit10 = ((SimpleSymbol) new SimpleSymbol("g$tempChange").readResolve());
    static final IntNum Lit100 = IntNum.make(136);
    static final IntNum Lit101 = IntNum.make(40);
    static final IntNum Lit102 = IntNum.make(147);
    static final PairWithPosition Lit103;
    static final PairWithPosition Lit104;
    static final PairWithPosition Lit105;
    static final PairWithPosition Lit106;
    static final SimpleSymbol Lit107 = ((SimpleSymbol) new SimpleSymbol("AboutScreenBackgroundColor").readResolve());
    static final IntNum Lit108;
    static final SimpleSymbol Lit109;
    static final SimpleSymbol Lit11 = ((SimpleSymbol) new SimpleSymbol("g$measurements").readResolve());
    static final SimpleSymbol Lit110 = ((SimpleSymbol) new SimpleSymbol("AboutScreenTitle").readResolve());
    static final SimpleSymbol Lit111;
    static final SimpleSymbol Lit112 = ((SimpleSymbol) new SimpleSymbol("AlignHorizontal").readResolve());
    static final IntNum Lit113 = IntNum.make(3);
    static final SimpleSymbol Lit114 = ((SimpleSymbol) new SimpleSymbol("AlignVertical").readResolve());
    static final IntNum Lit115 = IntNum.make(2);
    static final SimpleSymbol Lit116 = ((SimpleSymbol) new SimpleSymbol("AppId").readResolve());
    static final SimpleSymbol Lit117 = ((SimpleSymbol) new SimpleSymbol("AppName").readResolve());
    static final SimpleSymbol Lit118 = ((SimpleSymbol) new SimpleSymbol("BackgroundColor").readResolve());
    static final IntNum Lit119;
    static final SimpleSymbol Lit12 = ((SimpleSymbol) new SimpleSymbol("g$measurementsList").readResolve());
    static final SimpleSymbol Lit120 = ((SimpleSymbol) new SimpleSymbol("CloseScreenAnimation").readResolve());
    static final SimpleSymbol Lit121 = ((SimpleSymbol) new SimpleSymbol("NavigationBarColor").readResolve());
    static final IntNum Lit122 = IntNum.make(83951873);
    static final SimpleSymbol Lit123 = ((SimpleSymbol) new SimpleSymbol("OpenScreenAnimation").readResolve());
    static final SimpleSymbol Lit124 = ((SimpleSymbol) new SimpleSymbol("PrimaryColor").readResolve());
    static final IntNum Lit125;
    static final SimpleSymbol Lit126 = ((SimpleSymbol) new SimpleSymbol("PrimaryColorDark").readResolve());
    static final IntNum Lit127;
    static final SimpleSymbol Lit128 = ((SimpleSymbol) new SimpleSymbol("ReceiveSharedText").readResolve());
    static final SimpleSymbol Lit129 = ((SimpleSymbol) new SimpleSymbol("ScreenOrientation").readResolve());
    static final SimpleSymbol Lit13 = ((SimpleSymbol) new SimpleSymbol("g$goodAqi").readResolve());
    static final SimpleSymbol Lit130 = ((SimpleSymbol) new SimpleSymbol("SplashIcon").readResolve());
    static final SimpleSymbol Lit131 = ((SimpleSymbol) new SimpleSymbol("Title").readResolve());
    static final SimpleSymbol Lit132 = ((SimpleSymbol) new SimpleSymbol("TitleBarFontTypeface").readResolve());
    static final IntNum Lit133 = IntNum.make(5);
    static final SimpleSymbol Lit134 = ((SimpleSymbol) new SimpleSymbol("TitleBarTypefaceImport").readResolve());
    static final SimpleSymbol Lit135 = ((SimpleSymbol) new SimpleSymbol("Home").readResolve());
    static final SimpleSymbol Lit136 = ((SimpleSymbol) new SimpleSymbol("Visible").readResolve());
    static final SimpleSymbol Lit137;
    static final SimpleSymbol Lit138 = ((SimpleSymbol) new SimpleSymbol("Info").readResolve());
    static final SimpleSymbol Lit139 = ((SimpleSymbol) new SimpleSymbol("Devices").readResolve());
    static final IntNum Lit14 = IntNum.make(152);
    static final SimpleSymbol Lit140 = ((SimpleSymbol) new SimpleSymbol("Width").readResolve());
    static final IntNum Lit141 = IntNum.make(30);
    static final PairWithPosition Lit142;
    static final PairWithPosition Lit143;
    static final PairWithPosition Lit144;
    static final SimpleSymbol Lit145 = ((SimpleSymbol) new SimpleSymbol("Address").readResolve());
    static final PairWithPosition Lit146;
    static final SimpleSymbol Lit147 = ((SimpleSymbol) new SimpleSymbol("Instructions").readResolve());
    static final SimpleSymbol Lit148 = ((SimpleSymbol) new SimpleSymbol("Elements").readResolve());
    static final PairWithPosition Lit149;
    static final IntNum Lit15 = IntNum.make(227);
    static final SimpleSymbol Lit150;
    static final SimpleSymbol Lit151 = ((SimpleSymbol) new SimpleSymbol("About").readResolve());
    static final PairWithPosition Lit152;
    static final SimpleSymbol Lit153 = ((SimpleSymbol) new SimpleSymbol("About2").readResolve());
    static final PairWithPosition Lit154;
    static final SimpleSymbol Lit155 = ((SimpleSymbol) new SimpleSymbol("NavBar").readResolve());
    static final SimpleSymbol Lit156 = ((SimpleSymbol) new SimpleSymbol("AddItem").readResolve());
    static final IntNum Lit157 = IntNum.make(1);
    static final PairWithPosition Lit158;
    static final PairWithPosition Lit159;
    static final IntNum Lit16 = IntNum.make(94);
    static final PairWithPosition Lit160;
    static final SimpleSymbol Lit161 = ((SimpleSymbol) new SimpleSymbol("Screen1$Initialize").readResolve());
    static final SimpleSymbol Lit162 = ((SimpleSymbol) new SimpleSymbol("Initialize").readResolve());
    static final FString Lit163 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final SimpleSymbol Lit164 = ((SimpleSymbol) new SimpleSymbol("PaddingTop").readResolve());
    static final SimpleSymbol Lit165 = ((SimpleSymbol) new SimpleSymbol("Height").readResolve());
    static final IntNum Lit166 = IntNum.make(15);
    static final IntNum Lit167 = IntNum.make(-2);
    static final FString Lit168 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final FString Lit169 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final PairWithPosition Lit17;
    static final IntNum Lit170 = IntNum.make(67174657);
    static final FString Lit171 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit172 = new FString("com.google.appinventor.components.runtime.Image");
    static final SimpleSymbol Lit173 = ((SimpleSymbol) new SimpleSymbol("Image1").readResolve());
    static final IntNum Lit174 = IntNum.make((int) ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH);
    static final SimpleSymbol Lit175 = ((SimpleSymbol) new SimpleSymbol("Picture").readResolve());
    static final FString Lit176 = new FString("com.google.appinventor.components.runtime.Image");
    static final FString Lit177 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final SimpleSymbol Lit178 = ((SimpleSymbol) new SimpleSymbol("Space1").readResolve());
    static final FString Lit179 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final PairWithPosition Lit18;
    static final FString Lit180 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit181 = ((SimpleSymbol) new SimpleSymbol("Vertical_Arrangement1").readResolve());
    static final IntNum Lit182;
    static final IntNum Lit183 = IntNum.make(50);
    static final FString Lit184 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit185 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit186 = ((SimpleSymbol) new SimpleSymbol("Label1").readResolve());
    static final IntNum Lit187 = IntNum.make(6111872);
    static final SimpleSymbol Lit188 = ((SimpleSymbol) new SimpleSymbol("FontSize").readResolve());
    static final IntNum Lit189 = IntNum.make(13);
    static final PairWithPosition Lit19;
    static final SimpleSymbol Lit190 = ((SimpleSymbol) new SimpleSymbol("FontTypeface").readResolve());
    static final SimpleSymbol Lit191 = ((SimpleSymbol) new SimpleSymbol("FontTypefaceImport").readResolve());
    static final SimpleSymbol Lit192 = ((SimpleSymbol) new SimpleSymbol("HasMargins").readResolve());
    static final SimpleSymbol Lit193 = ((SimpleSymbol) new SimpleSymbol("Marquee").readResolve());
    static final SimpleSymbol Lit194 = ((SimpleSymbol) new SimpleSymbol("Text").readResolve());
    static final SimpleSymbol Lit195 = ((SimpleSymbol) new SimpleSymbol("TextAlignment").readResolve());
    static final SimpleSymbol Lit196 = ((SimpleSymbol) new SimpleSymbol("TextColor").readResolve());
    static final IntNum Lit197;
    static final FString Lit198 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit199 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final SimpleSymbol Lit2 = ((SimpleSymbol) new SimpleSymbol("*the-null-value*").readResolve());
    static final PairWithPosition Lit20;
    static final SimpleSymbol Lit200 = ((SimpleSymbol) new SimpleSymbol("Space2_copy").readResolve());
    static final FString Lit201 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final FString Lit202 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit203 = ((SimpleSymbol) new SimpleSymbol("Horizontal_Arrangement1").readResolve());
    static final FString Lit204 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit205 = new FString("com.google.appinventor.components.runtime.ListView");
    static final IntNum Lit206;
    static final SimpleSymbol Lit207 = ((SimpleSymbol) new SimpleSymbol("DividerColor").readResolve());
    static final IntNum Lit208;
    static final SimpleSymbol Lit209 = ((SimpleSymbol) new SimpleSymbol("DividerHeight").readResolve());
    static final SimpleSymbol Lit21 = ((SimpleSymbol) new SimpleSymbol("g$goodHazard").readResolve());
    static final SimpleSymbol Lit210 = ((SimpleSymbol) new SimpleSymbol("ItemHeight").readResolve());
    static final SimpleSymbol Lit211 = ((SimpleSymbol) new SimpleSymbol("SearchTextSize").readResolve());
    static final IntNum Lit212;
    static final SimpleSymbol Lit213 = ((SimpleSymbol) new SimpleSymbol("TextSize").readResolve());
    static final FString Lit214 = new FString("com.google.appinventor.components.runtime.ListView");
    static final SimpleSymbol Lit215 = ((SimpleSymbol) new SimpleSymbol("Selection").readResolve());
    static final SimpleSymbol Lit216 = ((SimpleSymbol) new SimpleSymbol("Bluetooth_Client1").readResolve());
    static final SimpleSymbol Lit217 = ((SimpleSymbol) new SimpleSymbol("Connect").readResolve());
    static final PairWithPosition Lit218;
    static final SimpleSymbol Lit219 = ((SimpleSymbol) new SimpleSymbol("Address$AfterPicking").readResolve());
    static final IntNum Lit22 = IntNum.make(66);
    static final SimpleSymbol Lit220 = ((SimpleSymbol) new SimpleSymbol("AfterPicking").readResolve());
    static final FString Lit221 = new FString("com.google.appinventor.components.runtime.ListView");
    static final SimpleSymbol Lit222 = ((SimpleSymbol) new SimpleSymbol("Name").readResolve());
    static final IntNum Lit223;
    static final IntNum Lit224;
    static final FString Lit225 = new FString("com.google.appinventor.components.runtime.ListView");
    static final FString Lit226 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final IntNum Lit227 = IntNum.make(67174657);
    static final FString Lit228 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit229 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final IntNum Lit23 = IntNum.make(220);
    static final SimpleSymbol Lit230 = ((SimpleSymbol) new SimpleSymbol("Horizontal_Arrangement2").readResolve());
    static final IntNum Lit231;
    static final IntNum Lit232 = IntNum.make(150);
    static final FString Lit233 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit234 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit235 = ((SimpleSymbol) new SimpleSymbol("Vertical_Arrangement2").readResolve());
    static final IntNum Lit236;
    static final IntNum Lit237 = IntNum.make(140);
    static final FString Lit238 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit239 = new FString("com.google.appinventor.components.runtime.Label");
    static final IntNum Lit24 = IntNum.make(118);
    static final SimpleSymbol Lit240 = ((SimpleSymbol) new SimpleSymbol("aqi").readResolve());
    static final IntNum Lit241 = IntNum.make(14);
    static final IntNum Lit242;
    static final FString Lit243 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit244 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit245 = ((SimpleSymbol) new SimpleSymbol("aqiVal").readResolve());
    static final SimpleSymbol Lit246 = ((SimpleSymbol) new SimpleSymbol("FontBold").readResolve());
    static final IntNum Lit247;
    static final FString Lit248 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit249 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final PairWithPosition Lit25;
    static final SimpleSymbol Lit250 = ((SimpleSymbol) new SimpleSymbol("Vertical_Arrangement3").readResolve());
    static final IntNum Lit251 = IntNum.make(16105662);
    static final FString Lit252 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit253 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit254 = ((SimpleSymbol) new SimpleSymbol("healthConcern").readResolve());
    static final IntNum Lit255;
    static final FString Lit256 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit257 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit258 = ((SimpleSymbol) new SimpleSymbol("very").readResolve());
    static final IntNum Lit259;
    static final PairWithPosition Lit26;
    static final FString Lit260 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit261 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit262 = ((SimpleSymbol) new SimpleSymbol("healthConcernVal").readResolve());
    static final IntNum Lit263 = IntNum.make(25);
    static final IntNum Lit264;
    static final FString Lit265 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit266 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit267 = ((SimpleSymbol) new SimpleSymbol("forSensGroups").readResolve());
    static final IntNum Lit268;
    static final FString Lit269 = new FString("com.google.appinventor.components.runtime.Label");
    static final PairWithPosition Lit27;
    static final FString Lit270 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final SimpleSymbol Lit271 = ((SimpleSymbol) new SimpleSymbol("Space3").readResolve());
    static final FString Lit272 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final FString Lit273 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit274 = ((SimpleSymbol) new SimpleSymbol("Horizontal_Arrangement4").readResolve());
    static final IntNum Lit275;
    static final FString Lit276 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit277 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit278 = ((SimpleSymbol) new SimpleSymbol("Horizontal_Arrangement5").readResolve());
    static final IntNum Lit279 = IntNum.make(-1045);
    static final PairWithPosition Lit28;
    static final FString Lit280 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit281 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final SimpleSymbol Lit282 = ((SimpleSymbol) new SimpleSymbol("Space4").readResolve());
    static final FString Lit283 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final FString Lit284 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit285 = ((SimpleSymbol) new SimpleSymbol("Label2").readResolve());
    static final IntNum Lit286;
    static final FString Lit287 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit288 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit289 = ((SimpleSymbol) new SimpleSymbol("Vertical_Arrangement5").readResolve());
    static final SimpleSymbol Lit29 = ((SimpleSymbol) new SimpleSymbol("g$moderateAqi").readResolve());
    static final IntNum Lit290 = IntNum.make(65793);
    static final IntNum Lit291 = IntNum.make(-1025);
    static final FString Lit292 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit293 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit294 = ((SimpleSymbol) new SimpleSymbol("Label3").readResolve());
    static final IntNum Lit295;
    static final FString Lit296 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit297 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit298 = ((SimpleSymbol) new SimpleSymbol("Vertical_Arrangement6").readResolve());
    static final IntNum Lit299 = IntNum.make(65536);
    static final SimpleSymbol Lit3 = ((SimpleSymbol) new SimpleSymbol("g$addressInput").readResolve());
    static final IntNum Lit30 = IntNum.make(255);
    static final FString Lit300 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit301 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit302 = ((SimpleSymbol) new SimpleSymbol("Label4").readResolve());
    static final IntNum Lit303;
    static final FString Lit304 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit305 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final SimpleSymbol Lit306 = ((SimpleSymbol) new SimpleSymbol("Space3_copy").readResolve());
    static final FString Lit307 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final FString Lit308 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit309 = ((SimpleSymbol) new SimpleSymbol("Horizontal_Arrangement3").readResolve());
    static final IntNum Lit31 = IntNum.make(197);
    static final FString Lit310 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit311 = new FString("com.google.appinventor.components.runtime.ListView");
    static final SimpleSymbol Lit312 = ((SimpleSymbol) new SimpleSymbol("measures").readResolve());
    static final IntNum Lit313;
    static final IntNum Lit314;
    static final SimpleSymbol Lit315 = ((SimpleSymbol) new SimpleSymbol("ElementsFromString").readResolve());
    static final SimpleSymbol Lit316 = ((SimpleSymbol) new SimpleSymbol("SelectionColor").readResolve());
    static final IntNum Lit317;
    static final IntNum Lit318;
    static final IntNum Lit319 = IntNum.make(-1045);
    static final IntNum Lit32 = IntNum.make(83);
    static final FString Lit320 = new FString("com.google.appinventor.components.runtime.ListView");
    static final FString Lit321 = new FString("com.google.appinventor.components.runtime.ListView");
    static final SimpleSymbol Lit322 = ((SimpleSymbol) new SimpleSymbol("values").readResolve());
    static final IntNum Lit323;
    static final IntNum Lit324;
    static final IntNum Lit325;
    static final IntNum Lit326 = IntNum.make(-1025);
    static final FString Lit327 = new FString("com.google.appinventor.components.runtime.ListView");
    static final FString Lit328 = new FString("com.google.appinventor.components.runtime.ListView");
    static final SimpleSymbol Lit329 = ((SimpleSymbol) new SimpleSymbol("unit").readResolve());
    static final PairWithPosition Lit33;
    static final IntNum Lit330;
    static final IntNum Lit331;
    static final SimpleSymbol Lit332 = ((SimpleSymbol) new SimpleSymbol("ScrollbarFading").readResolve());
    static final IntNum Lit333;
    static final FString Lit334 = new FString("com.google.appinventor.components.runtime.ListView");
    static final FString Lit335 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final IntNum Lit336 = IntNum.make(67174657);
    static final FString Lit337 = new FString("com.google.appinventor.components.runtime.VerticalScrollArrangement");
    static final FString Lit338 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit339 = ((SimpleSymbol) new SimpleSymbol("Vertical_Arrangement1_copy").readResolve());
    static final PairWithPosition Lit34;
    static final IntNum Lit340;
    static final FString Lit341 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit342 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit343 = ((SimpleSymbol) new SimpleSymbol("InstructionsLabel").readResolve());
    static final IntNum Lit344 = IntNum.make(6111872);
    static final IntNum Lit345;
    static final FString Lit346 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit347 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final SimpleSymbol Lit348 = ((SimpleSymbol) new SimpleSymbol("Space2_copy1").readResolve());
    static final FString Lit349 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final PairWithPosition Lit35;
    static final FString Lit350 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit351 = ((SimpleSymbol) new SimpleSymbol("Horizontal_Arrangement6").readResolve());
    static final FString Lit352 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit353 = new FString("com.google.appinventor.components.runtime.ListView");
    static final SimpleSymbol Lit354 = ((SimpleSymbol) new SimpleSymbol("Numbers").readResolve());
    static final IntNum Lit355;
    static final IntNum Lit356;
    static final IntNum Lit357 = IntNum.make(7);
    static final IntNum Lit358;
    static final IntNum Lit359 = IntNum.make(10);
    static final PairWithPosition Lit36;
    static final FString Lit360 = new FString("com.google.appinventor.components.runtime.ListView");
    static final FString Lit361 = new FString("com.google.appinventor.components.runtime.ListView");
    static final IntNum Lit362;
    static final IntNum Lit363;
    static final IntNum Lit364;
    static final FString Lit365 = new FString("com.google.appinventor.components.runtime.ListView");
    static final FString Lit366 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final SimpleSymbol Lit367 = ((SimpleSymbol) new SimpleSymbol("Space2").readResolve());
    static final FString Lit368 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final FString Lit369 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit37 = ((SimpleSymbol) new SimpleSymbol("g$moderateHazard").readResolve());
    static final SimpleSymbol Lit370 = ((SimpleSymbol) new SimpleSymbol("Vertical_Arrangement1_copy_copy").readResolve());
    static final IntNum Lit371;
    static final FString Lit372 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit373 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit374 = ((SimpleSymbol) new SimpleSymbol("AboutLabel").readResolve());
    static final IntNum Lit375 = IntNum.make(6111872);
    static final IntNum Lit376;
    static final FString Lit377 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit378 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final SimpleSymbol Lit379 = ((SimpleSymbol) new SimpleSymbol("Space2_copy2").readResolve());
    static final IntNum Lit38 = IntNum.make(155);
    static final FString Lit380 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final FString Lit381 = new FString("com.google.appinventor.components.runtime.ListView");
    static final IntNum Lit382;
    static final IntNum Lit383;
    static final IntNum Lit384 = IntNum.make(18);
    static final IntNum Lit385;
    static final FString Lit386 = new FString("com.google.appinventor.components.runtime.ListView");
    static final FString Lit387 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final SimpleSymbol Lit388 = ((SimpleSymbol) new SimpleSymbol("Space2_copy2_copy").readResolve());
    static final FString Lit389 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final IntNum Lit39 = IntNum.make(91);
    static final FString Lit390 = new FString("com.google.appinventor.components.runtime.ListView");
    static final IntNum Lit391;
    static final IntNum Lit392;
    static final IntNum Lit393 = IntNum.make(8);
    static final SimpleSymbol Lit394 = ((SimpleSymbol) new SimpleSymbol("LongClickEnabled").readResolve());
    static final IntNum Lit395;
    static final FString Lit396 = new FString("com.google.appinventor.components.runtime.ListView");
    static final FString Lit397 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit398 = ((SimpleSymbol) new SimpleSymbol("Spacing").readResolve());
    static final FString Lit399 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit4 = ((SimpleSymbol) new SimpleSymbol("g$alarm").readResolve());
    static final PairWithPosition Lit40;
    static final FString Lit400 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final SimpleSymbol Lit401 = ((SimpleSymbol) new SimpleSymbol("PaddingBottom").readResolve());
    static final FString Lit402 = new FString("com.google.appinventor.components.runtime.SpaceView");
    static final FString Lit403 = new FString("com.google.appinventor.components.runtime.KodularBottomNavigation");
    static final IntNum Lit404;
    static final SimpleSymbol Lit405 = ((SimpleSymbol) new SimpleSymbol("SelectedColor").readResolve());
    static final IntNum Lit406;
    static final SimpleSymbol Lit407 = ((SimpleSymbol) new SimpleSymbol("UnselectedColor").readResolve());
    static final IntNum Lit408;
    static final FString Lit409 = new FString("com.google.appinventor.components.runtime.KodularBottomNavigation");
    static final PairWithPosition Lit41;
    static final SimpleSymbol Lit410 = ((SimpleSymbol) new SimpleSymbol("$title").readResolve());
    static final PairWithPosition Lit411;
    static final PairWithPosition Lit412;
    static final SimpleSymbol Lit413 = ((SimpleSymbol) new SimpleSymbol("IsConnected").readResolve());
    static final PairWithPosition Lit414;
    static final SimpleSymbol Lit415 = ((SimpleSymbol) new SimpleSymbol("NavBar$ItemSelected").readResolve());
    static final SimpleSymbol Lit416 = ((SimpleSymbol) new SimpleSymbol("ItemSelected").readResolve());
    static final FString Lit417 = new FString("com.google.appinventor.components.runtime.BluetoothClient");
    static final FString Lit418 = new FString("com.google.appinventor.components.runtime.BluetoothClient");
    static final FString Lit419 = new FString("com.google.appinventor.components.runtime.Sound");
    static final PairWithPosition Lit42;
    static final SimpleSymbol Lit420 = ((SimpleSymbol) new SimpleSymbol("Sound1").readResolve());
    static final SimpleSymbol Lit421 = ((SimpleSymbol) new SimpleSymbol("MinimumInterval").readResolve());
    static final IntNum Lit422 = IntNum.make(100);
    static final FString Lit423 = new FString("com.google.appinventor.components.runtime.Sound");
    static final FString Lit424 = new FString("com.google.appinventor.components.runtime.Clock");
    static final SimpleSymbol Lit425 = ((SimpleSymbol) new SimpleSymbol("Clock1").readResolve());
    static final SimpleSymbol Lit426 = ((SimpleSymbol) new SimpleSymbol("TimerInterval").readResolve());
    static final IntNum Lit427 = IntNum.make(500);
    static final FString Lit428 = new FString("com.google.appinventor.components.runtime.Clock");
    static final SimpleSymbol Lit429 = ((SimpleSymbol) new SimpleSymbol("Enabled").readResolve());
    static final PairWithPosition Lit43;
    static final SimpleSymbol Lit430 = ((SimpleSymbol) new SimpleSymbol("BytesAvailableToReceive").readResolve());
    static final PairWithPosition Lit431;
    static final SimpleSymbol Lit432 = ((SimpleSymbol) new SimpleSymbol("ReceiveText").readResolve());
    static final PairWithPosition Lit433;
    static final PairWithPosition Lit434;
    static final PairWithPosition Lit435;
    static final PairWithPosition Lit436;
    static final PairWithPosition Lit437;
    static final PairWithPosition Lit438;
    static final PairWithPosition Lit439;
    static final SimpleSymbol Lit44 = ((SimpleSymbol) new SimpleSymbol("g$name9").readResolve());
    static final PairWithPosition Lit440;
    static final IntNum Lit441 = IntNum.make(9);
    static final PairWithPosition Lit442;
    static final IntNum Lit443 = IntNum.make(4);
    static final PairWithPosition Lit444;
    static final PairWithPosition Lit445;
    static final PairWithPosition Lit446;
    static final PairWithPosition Lit447;
    static final PairWithPosition Lit448;
    static final PairWithPosition Lit449;
    static final IntNum Lit45 = IntNum.make(0);
    static final PairWithPosition Lit450;
    static final PairWithPosition Lit451;
    static final PairWithPosition Lit452;
    static final PairWithPosition Lit453;
    static final PairWithPosition Lit454;
    static final PairWithPosition Lit455;
    static final PairWithPosition Lit456;
    static final PairWithPosition Lit457;
    static final PairWithPosition Lit458;
    static final PairWithPosition Lit459;
    static final PairWithPosition Lit46;
    static final IntNum Lit460 = IntNum.make(200);
    static final PairWithPosition Lit461;
    static final PairWithPosition Lit462;
    static final IntNum Lit463 = IntNum.make(300);
    static final PairWithPosition Lit464;
    static final PairWithPosition Lit465;
    static final PairWithPosition Lit466;
    static final SimpleSymbol Lit467 = ((SimpleSymbol) new SimpleSymbol("AddressesAndNames").readResolve());
    static final SimpleSymbol Lit468 = ((SimpleSymbol) new SimpleSymbol("Clock1$Timer").readResolve());
    static final SimpleSymbol Lit469 = ((SimpleSymbol) new SimpleSymbol("Timer").readResolve());
    static final PairWithPosition Lit47;
    static final FString Lit470 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final SimpleSymbol Lit471 = ((SimpleSymbol) new SimpleSymbol("Notifier1").readResolve());
    static final IntNum Lit472;
    static final SimpleSymbol Lit473 = ((SimpleSymbol) new SimpleSymbol("LightTheme").readResolve());
    static final SimpleSymbol Lit474 = ((SimpleSymbol) new SimpleSymbol("NotifierLength").readResolve());
    static final IntNum Lit475;
    static final SimpleSymbol Lit476 = ((SimpleSymbol) new SimpleSymbol("TextFontTypefaceImport").readResolve());
    static final SimpleSymbol Lit477 = ((SimpleSymbol) new SimpleSymbol("TitleColor").readResolve());
    static final IntNum Lit478;
    static final SimpleSymbol Lit479 = ((SimpleSymbol) new SimpleSymbol("TitleFontTypefaceImport").readResolve());
    static final PairWithPosition Lit48;
    static final FString Lit480 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final FString Lit481 = new FString("com.google.appinventor.components.runtime.Clock");
    static final SimpleSymbol Lit482 = ((SimpleSymbol) new SimpleSymbol("VibrationClock").readResolve());
    static final IntNum Lit483 = IntNum.make(750);
    static final FString Lit484 = new FString("com.google.appinventor.components.runtime.Clock");
    static final PairWithPosition Lit485;
    static final PairWithPosition Lit486;
    static final PairWithPosition Lit487;
    static final PairWithPosition Lit488;
    static final PairWithPosition Lit489;
    static final PairWithPosition Lit49;
    static final PairWithPosition Lit490;
    static final PairWithPosition Lit491;
    static final PairWithPosition Lit492;
    static final PairWithPosition Lit493;
    static final IntNum Lit494 = IntNum.make((int) ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    static final PairWithPosition Lit495;
    static final PairWithPosition Lit496;
    static final SimpleSymbol Lit497 = ((SimpleSymbol) new SimpleSymbol("Vibrate").readResolve());
    static final PairWithPosition Lit498;
    static final SimpleSymbol Lit499 = ((SimpleSymbol) new SimpleSymbol("VibrationClock$Timer").readResolve());
    static final SimpleSymbol Lit5 = ((SimpleSymbol) new SimpleSymbol("g$list").readResolve());
    static final SimpleSymbol Lit50 = ((SimpleSymbol) new SimpleSymbol("g$unhealthysgAqi").readResolve());
    static final FString Lit500 = new FString("com.google.appinventor.components.runtime.Clock");
    static final SimpleSymbol Lit501 = ((SimpleSymbol) new SimpleSymbol("NotifierClock").readResolve());
    static final IntNum Lit502 = IntNum.make(10000);
    static final FString Lit503 = new FString("com.google.appinventor.components.runtime.Clock");
    static final PairWithPosition Lit504;
    static final PairWithPosition Lit505;
    static final PairWithPosition Lit506;
    static final PairWithPosition Lit507;
    static final PairWithPosition Lit508;
    static final PairWithPosition Lit509;
    static final IntNum Lit51 = IntNum.make(158);
    static final PairWithPosition Lit510;
    static final PairWithPosition Lit511;
    static final PairWithPosition Lit512;
    static final PairWithPosition Lit513;
    static final PairWithPosition Lit514;
    static final SimpleSymbol Lit515 = ((SimpleSymbol) new SimpleSymbol("ShowLinearProgress").readResolve());
    static final PairWithPosition Lit516;
    static final SimpleSymbol Lit517 = ((SimpleSymbol) new SimpleSymbol("NotifierClock$Timer").readResolve());
    static final FString Lit518 = new FString("com.google.appinventor.components.runtime.Decoration");
    static final SimpleSymbol Lit519 = ((SimpleSymbol) new SimpleSymbol("Decoration1").readResolve());
    static final IntNum Lit52 = IntNum.make(89);
    static final FString Lit520 = new FString("com.google.appinventor.components.runtime.Decoration");
    static final SimpleSymbol Lit521 = ((SimpleSymbol) new SimpleSymbol("get-simple-name").readResolve());
    static final SimpleSymbol Lit522 = ((SimpleSymbol) new SimpleSymbol("android-log-form").readResolve());
    static final SimpleSymbol Lit523 = ((SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve());
    static final SimpleSymbol Lit524 = ((SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve());
    static final SimpleSymbol Lit525 = ((SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve());
    static final SimpleSymbol Lit526 = ((SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve());
    static final SimpleSymbol Lit527 = ((SimpleSymbol) new SimpleSymbol("add-to-events").readResolve());
    static final SimpleSymbol Lit528 = ((SimpleSymbol) new SimpleSymbol("add-to-components").readResolve());
    static final SimpleSymbol Lit529 = ((SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve());
    static final PairWithPosition Lit53;
    static final SimpleSymbol Lit530 = ((SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve());
    static final SimpleSymbol Lit531 = ((SimpleSymbol) new SimpleSymbol("send-error").readResolve());
    static final SimpleSymbol Lit532 = ((SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve());
    static final SimpleSymbol Lit533 = ((SimpleSymbol) new SimpleSymbol("dispatchGenericEvent").readResolve());
    static final SimpleSymbol Lit534 = ((SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve());
    static final SimpleSymbol Lit535;
    static final PairWithPosition Lit54;
    static final PairWithPosition Lit55;
    static final PairWithPosition Lit56;
    static final SimpleSymbol Lit57 = ((SimpleSymbol) new SimpleSymbol("g$unhealthysgHazard").readResolve());
    static final IntNum Lit58 = IntNum.make(93);
    static final PairWithPosition Lit59;
    static final SimpleSymbol Lit6 = ((SimpleSymbol) new SimpleSymbol("g$nox").readResolve());
    static final PairWithPosition Lit60;
    static final PairWithPosition Lit61;
    static final PairWithPosition Lit62;
    static final SimpleSymbol Lit63 = ((SimpleSymbol) new SimpleSymbol("g$unhealthyAqi").readResolve());
    static final IntNum Lit64 = IntNum.make(82);
    static final IntNum Lit65 = IntNum.make(113);
    static final PairWithPosition Lit66;
    static final PairWithPosition Lit67;
    static final PairWithPosition Lit68;
    static final PairWithPosition Lit69;
    static final SimpleSymbol Lit7 = ((SimpleSymbol) new SimpleSymbol("g$input").readResolve());
    static final SimpleSymbol Lit70 = ((SimpleSymbol) new SimpleSymbol("g$unhealthyHazard").readResolve());
    static final IntNum Lit71 = IntNum.make((int) FullScreenVideoUtil.FULLSCREEN_VIDEO_DIALOG_FLAG);
    static final IntNum Lit72 = IntNum.make(55);
    static final IntNum Lit73 = IntNum.make(99);
    static final PairWithPosition Lit74;
    static final PairWithPosition Lit75;
    static final PairWithPosition Lit76;
    static final PairWithPosition Lit77;
    static final SimpleSymbol Lit78 = ((SimpleSymbol) new SimpleSymbol("g$vunhealthyAqi").readResolve());
    static final IntNum Lit79 = IntNum.make(204);
    static final SimpleSymbol Lit8 = ((SimpleSymbol) new SimpleSymbol("g$voc").readResolve());
    static final PairWithPosition Lit80;
    static final PairWithPosition Lit81;
    static final PairWithPosition Lit82;
    static final PairWithPosition Lit83;
    static final SimpleSymbol Lit84 = ((SimpleSymbol) new SimpleSymbol("g$vunhealthyHazard").readResolve());
    static final IntNum Lit85 = IntNum.make(72);
    static final IntNum Lit86 = IntNum.make(232);
    static final PairWithPosition Lit87;
    static final PairWithPosition Lit88;
    static final PairWithPosition Lit89;
    static final SimpleSymbol Lit9 = ((SimpleSymbol) new SimpleSymbol("g$aqi").readResolve());
    static final PairWithPosition Lit90;
    static final SimpleSymbol Lit91 = ((SimpleSymbol) new SimpleSymbol("g$hazardousAqi").readResolve());
    static final IntNum Lit92 = IntNum.make(177);
    static final IntNum Lit93 = IntNum.make(62);
    static final IntNum Lit94 = IntNum.make(145);
    static final PairWithPosition Lit95;
    static final PairWithPosition Lit96;
    static final PairWithPosition Lit97;
    static final PairWithPosition Lit98;
    static final SimpleSymbol Lit99 = ((SimpleSymbol) new SimpleSymbol("g$hazardousHazard").readResolve());
    public static Screen1 Screen1;
    static final ModuleMethod lambda$Fn1 = null;
    static final ModuleMethod lambda$Fn10 = null;
    static final ModuleMethod lambda$Fn100 = null;
    static final ModuleMethod lambda$Fn101 = null;
    static final ModuleMethod lambda$Fn102 = null;
    static final ModuleMethod lambda$Fn103 = null;
    static final ModuleMethod lambda$Fn104 = null;
    static final ModuleMethod lambda$Fn105 = null;
    static final ModuleMethod lambda$Fn106 = null;
    static final ModuleMethod lambda$Fn107 = null;
    static final ModuleMethod lambda$Fn108 = null;
    static final ModuleMethod lambda$Fn109 = null;
    static final ModuleMethod lambda$Fn11 = null;
    static final ModuleMethod lambda$Fn110 = null;
    static final ModuleMethod lambda$Fn111 = null;
    static final ModuleMethod lambda$Fn112 = null;
    static final ModuleMethod lambda$Fn113 = null;
    static final ModuleMethod lambda$Fn114 = null;
    static final ModuleMethod lambda$Fn115 = null;
    static final ModuleMethod lambda$Fn116 = null;
    static final ModuleMethod lambda$Fn117 = null;
    static final ModuleMethod lambda$Fn118 = null;
    static final ModuleMethod lambda$Fn119 = null;
    static final ModuleMethod lambda$Fn12 = null;
    static final ModuleMethod lambda$Fn120 = null;
    static final ModuleMethod lambda$Fn121 = null;
    static final ModuleMethod lambda$Fn122 = null;
    static final ModuleMethod lambda$Fn123 = null;
    static final ModuleMethod lambda$Fn124 = null;
    static final ModuleMethod lambda$Fn125 = null;
    static final ModuleMethod lambda$Fn126 = null;
    static final ModuleMethod lambda$Fn127 = null;
    static final ModuleMethod lambda$Fn128 = null;
    static final ModuleMethod lambda$Fn129 = null;
    static final ModuleMethod lambda$Fn13 = null;
    static final ModuleMethod lambda$Fn130 = null;
    static final ModuleMethod lambda$Fn131 = null;
    static final ModuleMethod lambda$Fn132 = null;
    static final ModuleMethod lambda$Fn133 = null;
    static final ModuleMethod lambda$Fn134 = null;
    static final ModuleMethod lambda$Fn135 = null;
    static final ModuleMethod lambda$Fn136 = null;
    static final ModuleMethod lambda$Fn137 = null;
    static final ModuleMethod lambda$Fn138 = null;
    static final ModuleMethod lambda$Fn139 = null;
    static final ModuleMethod lambda$Fn14 = null;
    static final ModuleMethod lambda$Fn140 = null;
    static final ModuleMethod lambda$Fn141 = null;
    static final ModuleMethod lambda$Fn142 = null;
    static final ModuleMethod lambda$Fn143 = null;
    static final ModuleMethod lambda$Fn144 = null;
    static final ModuleMethod lambda$Fn145 = null;
    static final ModuleMethod lambda$Fn146 = null;
    static final ModuleMethod lambda$Fn147 = null;
    static final ModuleMethod lambda$Fn148 = null;
    static final ModuleMethod lambda$Fn149 = null;
    static final ModuleMethod lambda$Fn15 = null;
    static final ModuleMethod lambda$Fn150 = null;
    static final ModuleMethod lambda$Fn151 = null;
    static final ModuleMethod lambda$Fn152 = null;
    static final ModuleMethod lambda$Fn153 = null;
    static final ModuleMethod lambda$Fn154 = null;
    static final ModuleMethod lambda$Fn155 = null;
    static final ModuleMethod lambda$Fn156 = null;
    static final ModuleMethod lambda$Fn157 = null;
    static final ModuleMethod lambda$Fn158 = null;
    static final ModuleMethod lambda$Fn159 = null;
    static final ModuleMethod lambda$Fn16 = null;
    static final ModuleMethod lambda$Fn160 = null;
    static final ModuleMethod lambda$Fn161 = null;
    static final ModuleMethod lambda$Fn162 = null;
    static final ModuleMethod lambda$Fn163 = null;
    static final ModuleMethod lambda$Fn164 = null;
    static final ModuleMethod lambda$Fn165 = null;
    static final ModuleMethod lambda$Fn166 = null;
    static final ModuleMethod lambda$Fn167 = null;
    static final ModuleMethod lambda$Fn168 = null;
    static final ModuleMethod lambda$Fn169 = null;
    static final ModuleMethod lambda$Fn17 = null;
    static final ModuleMethod lambda$Fn18 = null;
    static final ModuleMethod lambda$Fn19 = null;
    static final ModuleMethod lambda$Fn2 = null;
    static final ModuleMethod lambda$Fn20 = null;
    static final ModuleMethod lambda$Fn21 = null;
    static final ModuleMethod lambda$Fn22 = null;
    static final ModuleMethod lambda$Fn23 = null;
    static final ModuleMethod lambda$Fn24 = null;
    static final ModuleMethod lambda$Fn25 = null;
    static final ModuleMethod lambda$Fn26 = null;
    static final ModuleMethod lambda$Fn27 = null;
    static final ModuleMethod lambda$Fn28 = null;
    static final ModuleMethod lambda$Fn29 = null;
    static final ModuleMethod lambda$Fn3 = null;
    static final ModuleMethod lambda$Fn30 = null;
    static final ModuleMethod lambda$Fn31 = null;
    static final ModuleMethod lambda$Fn32 = null;
    static final ModuleMethod lambda$Fn33 = null;
    static final ModuleMethod lambda$Fn34 = null;
    static final ModuleMethod lambda$Fn35 = null;
    static final ModuleMethod lambda$Fn36 = null;
    static final ModuleMethod lambda$Fn37 = null;
    static final ModuleMethod lambda$Fn38 = null;
    static final ModuleMethod lambda$Fn39 = null;
    static final ModuleMethod lambda$Fn4 = null;
    static final ModuleMethod lambda$Fn40 = null;
    static final ModuleMethod lambda$Fn41 = null;
    static final ModuleMethod lambda$Fn42 = null;
    static final ModuleMethod lambda$Fn43 = null;
    static final ModuleMethod lambda$Fn44 = null;
    static final ModuleMethod lambda$Fn45 = null;
    static final ModuleMethod lambda$Fn46 = null;
    static final ModuleMethod lambda$Fn47 = null;
    static final ModuleMethod lambda$Fn48 = null;
    static final ModuleMethod lambda$Fn49 = null;
    static final ModuleMethod lambda$Fn5 = null;
    static final ModuleMethod lambda$Fn50 = null;
    static final ModuleMethod lambda$Fn51 = null;
    static final ModuleMethod lambda$Fn52 = null;
    static final ModuleMethod lambda$Fn53 = null;
    static final ModuleMethod lambda$Fn54 = null;
    static final ModuleMethod lambda$Fn55 = null;
    static final ModuleMethod lambda$Fn56 = null;
    static final ModuleMethod lambda$Fn57 = null;
    static final ModuleMethod lambda$Fn58 = null;
    static final ModuleMethod lambda$Fn59 = null;
    static final ModuleMethod lambda$Fn6 = null;
    static final ModuleMethod lambda$Fn60 = null;
    static final ModuleMethod lambda$Fn61 = null;
    static final ModuleMethod lambda$Fn62 = null;
    static final ModuleMethod lambda$Fn63 = null;
    static final ModuleMethod lambda$Fn64 = null;
    static final ModuleMethod lambda$Fn65 = null;
    static final ModuleMethod lambda$Fn66 = null;
    static final ModuleMethod lambda$Fn67 = null;
    static final ModuleMethod lambda$Fn68 = null;
    static final ModuleMethod lambda$Fn69 = null;
    static final ModuleMethod lambda$Fn7 = null;
    static final ModuleMethod lambda$Fn70 = null;
    static final ModuleMethod lambda$Fn71 = null;
    static final ModuleMethod lambda$Fn72 = null;
    static final ModuleMethod lambda$Fn73 = null;
    static final ModuleMethod lambda$Fn74 = null;
    static final ModuleMethod lambda$Fn75 = null;
    static final ModuleMethod lambda$Fn76 = null;
    static final ModuleMethod lambda$Fn77 = null;
    static final ModuleMethod lambda$Fn78 = null;
    static final ModuleMethod lambda$Fn79 = null;
    static final ModuleMethod lambda$Fn8 = null;
    static final ModuleMethod lambda$Fn80 = null;
    static final ModuleMethod lambda$Fn81 = null;
    static final ModuleMethod lambda$Fn82 = null;
    static final ModuleMethod lambda$Fn83 = null;
    static final ModuleMethod lambda$Fn84 = null;
    static final ModuleMethod lambda$Fn85 = null;
    static final ModuleMethod lambda$Fn86 = null;
    static final ModuleMethod lambda$Fn87 = null;
    static final ModuleMethod lambda$Fn88 = null;
    static final ModuleMethod lambda$Fn89 = null;
    static final ModuleMethod lambda$Fn9 = null;
    static final ModuleMethod lambda$Fn90 = null;
    static final ModuleMethod lambda$Fn91 = null;
    static final ModuleMethod lambda$Fn92 = null;
    static final ModuleMethod lambda$Fn93 = null;
    static final ModuleMethod lambda$Fn94 = null;
    static final ModuleMethod lambda$Fn95 = null;
    static final ModuleMethod lambda$Fn96 = null;
    static final ModuleMethod lambda$Fn97 = null;
    static final ModuleMethod lambda$Fn98 = null;
    static final ModuleMethod lambda$Fn99 = null;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public ListView About;
    public ListView About2;
    public Label AboutLabel;
    public ListView Address;
    public final ModuleMethod Address$AfterPicking;
    public BluetoothClient Bluetooth_Client1;
    public Clock Clock1;
    public final ModuleMethod Clock1$Timer;
    public Decoration Decoration1;
    public VerticalScrollArrangement Devices;
    public VerticalScrollArrangement Home;
    public HorizontalArrangement Horizontal_Arrangement1;
    public HorizontalArrangement Horizontal_Arrangement2;
    public HorizontalArrangement Horizontal_Arrangement3;
    public HorizontalArrangement Horizontal_Arrangement4;
    public HorizontalArrangement Horizontal_Arrangement5;
    public HorizontalArrangement Horizontal_Arrangement6;
    public Image Image1;
    public VerticalScrollArrangement Info;
    public ListView Instructions;
    public Label InstructionsLabel;
    public Label Label1;
    public Label Label2;
    public Label Label3;
    public Label Label4;
    public ListView Name;
    public KodularBottomNavigation NavBar;
    public final ModuleMethod NavBar$ItemSelected;
    public Notifier Notifier1;
    public Clock NotifierClock;
    public final ModuleMethod NotifierClock$Timer;
    public ListView Numbers;
    public SpaceView PaddingBottom;
    public SpaceView PaddingTop;
    public final ModuleMethod Screen1$Initialize;
    public Sound Sound1;
    public SpaceView Space1;
    public SpaceView Space2;
    public SpaceView Space2_copy;
    public SpaceView Space2_copy1;
    public SpaceView Space2_copy2;
    public SpaceView Space2_copy2_copy;
    public SpaceView Space3;
    public SpaceView Space3_copy;
    public SpaceView Space4;
    public VerticalArrangement Spacing;
    public VerticalArrangement Vertical_Arrangement1;
    public VerticalArrangement Vertical_Arrangement1_copy;
    public VerticalArrangement Vertical_Arrangement1_copy_copy;
    public VerticalArrangement Vertical_Arrangement2;
    public VerticalArrangement Vertical_Arrangement3;
    public VerticalArrangement Vertical_Arrangement5;
    public VerticalArrangement Vertical_Arrangement6;
    public Clock VibrationClock;
    public final ModuleMethod VibrationClock$Timer;
    public final ModuleMethod add$Mnto$Mncomponents;
    public final ModuleMethod add$Mnto$Mnevents;
    public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
    public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
    public final ModuleMethod android$Mnlog$Mnform;
    public Label aqi;
    public Label aqiVal;
    public LList components$Mnto$Mncreate;
    public final ModuleMethod dispatchEvent;
    public final ModuleMethod dispatchGenericEvent;
    public LList events$Mnto$Mnregister;
    public Label forSensGroups;
    public LList form$Mndo$Mnafter$Mncreation;
    public Environment form$Mnenvironment;
    public Symbol form$Mnname$Mnsymbol;
    public final ModuleMethod get$Mnsimple$Mnname;
    public Environment global$Mnvar$Mnenvironment;
    public LList global$Mnvars$Mnto$Mncreate;
    public Label healthConcern;
    public Label healthConcernVal;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public ListView measures;
    public final ModuleMethod process$Mnexception;
    public final ModuleMethod send$Mnerror;
    public ListView unit;
    public ListView values;
    public Label very;

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol("any").readResolve();
        Lit535 = simpleSymbol;
        SimpleSymbol simpleSymbol2 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
        Lit111 = simpleSymbol2;
        SimpleSymbol simpleSymbol3 = (SimpleSymbol) new SimpleSymbol("boolean").readResolve();
        Lit137 = simpleSymbol3;
        SimpleSymbol simpleSymbol4 = (SimpleSymbol) new SimpleSymbol("number").readResolve();
        Lit109 = simpleSymbol4;
        Lit516 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol3, PairWithPosition.make(simpleSymbol3, PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3634436), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3634429), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3634421), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3634413), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3634408), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3634402);
        Lit514 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3634237), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3634229);
        Lit513 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3634149), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3634141);
        Lit512 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3634061), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3634053);
        Lit511 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3633967), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3633959);
        Lit510 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3633880), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3633872);
        Lit509 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3633757), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3633752);
        Lit508 = PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3633722);
        Lit507 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3633586), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3633581);
        SimpleSymbol simpleSymbol5 = (SimpleSymbol) new SimpleSymbol("list").readResolve();
        Lit150 = simpleSymbol5;
        Lit506 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3633552);
        Lit505 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3633399), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3633394);
        Lit504 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3633365);
        Lit498 = PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3597463);
        Lit496 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3597373), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3597365);
        Lit495 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3597285), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3597277);
        Lit493 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3597197), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3597189);
        Lit492 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3597103), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3597095);
        Lit491 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3597016), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3597008);
        Lit490 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3596893), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3596888);
        Lit489 = PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3596858);
        Lit488 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3596722), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3596717);
        Lit487 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3596688);
        Lit486 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3596535), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3596530);
        Lit485 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3596501);
        int[] iArr = new int[2];
        iArr[0] = -16777216;
        Lit478 = IntNum.make(iArr);
        int[] iArr2 = new int[2];
        iArr2[0] = -16777216;
        Lit475 = IntNum.make(iArr2);
        int[] iArr3 = new int[2];
        iArr3[0] = -1;
        Lit472 = IntNum.make(iArr3);
        Lit466 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3487452), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3487444);
        Lit465 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3487365), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3487357);
        Lit464 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3486854), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3486846);
        Lit462 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3486767), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3486759);
        Lit461 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3486258), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3486250);
        Lit459 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3486171), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3486163);
        Lit458 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3485658), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3485650);
        Lit457 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3485571), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3485563);
        Lit456 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3485457), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3485449);
        Lit455 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3485370), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3485362);
        Lit454 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3484860), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3484852);
        Lit453 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3484773), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3484765);
        Lit452 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3484280), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3484272);
        Lit451 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3484194), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3484186);
        Lit450 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3484082), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3484074);
        Lit449 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3483995), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3483987);
        Lit448 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3483887), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3483882);
        Lit447 = PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3483852);
        Lit446 = PairWithPosition.make(simpleSymbol5, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3483607), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3483601);
        Lit445 = PairWithPosition.make(simpleSymbol5, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3483464), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3483458);
        Lit444 = PairWithPosition.make(simpleSymbol5, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3483321), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3483315);
        Lit442 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3483180), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3483175);
        Lit440 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3483146);
        Lit439 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3482984), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3482978);
        Lit438 = PairWithPosition.make(simpleSymbol5, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3482836), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3482830);
        Lit437 = PairWithPosition.make(simpleSymbol5, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3482696), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3482690);
        Lit436 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3482574), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3482569);
        Lit435 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3482540);
        Lit434 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3482390), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3482384);
        Lit433 = PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3482279);
        Lit431 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3482069), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3482061);
        Lit414 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3396657), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3396652);
        Lit412 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3396026), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3396021);
        Lit411 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3395686), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 3395681);
        int[] iArr4 = new int[2];
        iArr4[0] = -1963066373;
        Lit408 = IntNum.make(iArr4);
        int[] iArr5 = new int[2];
        iArr5[0] = -1;
        Lit406 = IntNum.make(iArr5);
        int[] iArr6 = new int[2];
        iArr6[0] = -12634517;
        Lit404 = IntNum.make(iArr6);
        int[] iArr7 = new int[2];
        iArr7[0] = -1;
        Lit395 = IntNum.make(iArr7);
        int[] iArr8 = new int[2];
        iArr8[0] = -14278590;
        Lit392 = IntNum.make(iArr8);
        int[] iArr9 = new int[2];
        iArr9[0] = -12634517;
        Lit391 = IntNum.make(iArr9);
        int[] iArr10 = new int[2];
        iArr10[0] = -1;
        Lit385 = IntNum.make(iArr10);
        int[] iArr11 = new int[2];
        iArr11[0] = -14278590;
        Lit383 = IntNum.make(iArr11);
        int[] iArr12 = new int[2];
        iArr12[0] = -12634517;
        Lit382 = IntNum.make(iArr12);
        int[] iArr13 = new int[2];
        iArr13[0] = -1;
        Lit376 = IntNum.make(iArr13);
        int[] iArr14 = new int[2];
        iArr14[0] = -10665344;
        Lit371 = IntNum.make(iArr14);
        int[] iArr15 = new int[2];
        iArr15[0] = -1;
        Lit364 = IntNum.make(iArr15);
        int[] iArr16 = new int[2];
        iArr16[0] = -14278590;
        Lit363 = IntNum.make(iArr16);
        int[] iArr17 = new int[2];
        iArr17[0] = -12634517;
        Lit362 = IntNum.make(iArr17);
        int[] iArr18 = new int[2];
        iArr18[0] = -1;
        Lit358 = IntNum.make(iArr18);
        int[] iArr19 = new int[2];
        iArr19[0] = -14278590;
        Lit356 = IntNum.make(iArr19);
        int[] iArr20 = new int[2];
        iArr20[0] = -12634517;
        Lit355 = IntNum.make(iArr20);
        int[] iArr21 = new int[2];
        iArr21[0] = -1;
        Lit345 = IntNum.make(iArr21);
        int[] iArr22 = new int[2];
        iArr22[0] = -10665344;
        Lit340 = IntNum.make(iArr22);
        int[] iArr23 = new int[2];
        iArr23[0] = -1;
        Lit333 = IntNum.make(iArr23);
        int[] iArr24 = new int[2];
        iArr24[0] = -14278590;
        Lit331 = IntNum.make(iArr24);
        int[] iArr25 = new int[2];
        iArr25[0] = -13094816;
        Lit330 = IntNum.make(iArr25);
        int[] iArr26 = new int[2];
        iArr26[0] = -1;
        Lit325 = IntNum.make(iArr26);
        int[] iArr27 = new int[2];
        iArr27[0] = -14278590;
        Lit324 = IntNum.make(iArr27);
        int[] iArr28 = new int[2];
        iArr28[0] = -13094816;
        Lit323 = IntNum.make(iArr28);
        int[] iArr29 = new int[2];
        iArr29[0] = -1;
        Lit318 = IntNum.make(iArr29);
        int[] iArr30 = new int[2];
        iArr30[0] = -1118482;
        Lit317 = IntNum.make(iArr30);
        int[] iArr31 = new int[2];
        iArr31[0] = -14278590;
        Lit314 = IntNum.make(iArr31);
        int[] iArr32 = new int[2];
        iArr32[0] = -13094816;
        Lit313 = IntNum.make(iArr32);
        int[] iArr33 = new int[2];
        iArr33[0] = -1;
        Lit303 = IntNum.make(iArr33);
        int[] iArr34 = new int[2];
        iArr34[0] = -1;
        Lit295 = IntNum.make(iArr34);
        int[] iArr35 = new int[2];
        iArr35[0] = -1;
        Lit286 = IntNum.make(iArr35);
        int[] iArr36 = new int[2];
        iArr36[0] = -10665344;
        Lit275 = IntNum.make(iArr36);
        int[] iArr37 = new int[2];
        iArr37[0] = -1;
        Lit268 = IntNum.make(iArr37);
        int[] iArr38 = new int[2];
        iArr38[0] = -1;
        Lit264 = IntNum.make(iArr38);
        int[] iArr39 = new int[2];
        iArr39[0] = -1;
        Lit259 = IntNum.make(iArr39);
        int[] iArr40 = new int[2];
        iArr40[0] = -1258423301;
        Lit255 = IntNum.make(iArr40);
        int[] iArr41 = new int[2];
        iArr41[0] = -1;
        Lit247 = IntNum.make(iArr41);
        int[] iArr42 = new int[2];
        iArr42[0] = -1258423301;
        Lit242 = IntNum.make(iArr42);
        int[] iArr43 = new int[2];
        iArr43[0] = -6757538;
        Lit236 = IntNum.make(iArr43);
        int[] iArr44 = new int[2];
        iArr44[0] = -12395403;
        Lit231 = IntNum.make(iArr44);
        int[] iArr45 = new int[2];
        iArr45[0] = -1;
        Lit224 = IntNum.make(iArr45);
        int[] iArr46 = new int[2];
        iArr46[0] = -13094816;
        Lit223 = IntNum.make(iArr46);
        Lit218 = PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 700575);
        int[] iArr47 = new int[2];
        iArr47[0] = -1;
        Lit212 = IntNum.make(iArr47);
        int[] iArr48 = new int[2];
        iArr48[0] = -14278590;
        Lit208 = IntNum.make(iArr48);
        int[] iArr49 = new int[2];
        iArr49[0] = -12634517;
        Lit206 = IntNum.make(iArr49);
        int[] iArr50 = new int[2];
        iArr50[0] = -1;
        Lit197 = IntNum.make(iArr50);
        int[] iArr51 = new int[2];
        iArr51[0] = -10665344;
        Lit182 = IntNum.make(iArr51);
        Lit160 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 223292), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 223287), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 223279);
        Lit159 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 223189), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 223184), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 223176);
        Lit158 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 223086), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 223081), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 223073);
        Lit154 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 222956), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 222951);
        Lit152 = PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 222649);
        Lit149 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 222267), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 222263), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 222259), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 222254);
        Lit146 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 221868), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 221860);
        Lit144 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 221718), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 221710);
        Lit143 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 221571), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 221563);
        Lit142 = PairWithPosition.make(simpleSymbol4, PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 221424), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 221416);
        int[] iArr52 = new int[2];
        iArr52[0] = -12634517;
        Lit127 = IntNum.make(iArr52);
        int[] iArr53 = new int[2];
        iArr53[0] = -12634517;
        Lit125 = IntNum.make(iArr53);
        int[] iArr54 = new int[2];
        iArr54[0] = -14278590;
        Lit119 = IntNum.make(iArr54);
        int[] iArr55 = new int[2];
        iArr55[0] = -1;
        Lit108 = IntNum.make(iArr55);
        Lit106 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 123058);
        Lit105 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 123035), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 123031), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 123026);
        Lit104 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 123058);
        Lit103 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 123035), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 123031), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 123026);
        Lit98 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 118959);
        Lit97 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 118936), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 118932), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 118927);
        Lit96 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 118959);
        Lit95 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 118936), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 118932), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 118927);
        Lit90 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 114867);
        Lit89 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 114844), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 114840), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 114835);
        Lit88 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 114867);
        Lit87 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 114844), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 114840), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 114835);
        Lit83 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 110768);
        Lit82 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 110745), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 110741), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 110736);
        Lit81 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 110768);
        Lit80 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 110745), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 110741), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 110736);
        Lit77 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 106673);
        Lit76 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 106650), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 106646), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 106641);
        Lit75 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 106673);
        Lit74 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 106650), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 106646), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 106641);
        Lit69 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 102575);
        Lit68 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 102552), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 102548), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 102543);
        Lit67 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 102575);
        Lit66 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 102552), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 102548), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 102543);
        Lit62 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 98484);
        Lit61 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 98461), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 98457), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 98452);
        Lit60 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 98484);
        Lit59 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 98461), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 98457), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 98452);
        Lit56 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 94385);
        Lit55 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 94362), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 94358), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 94353);
        Lit54 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 94385);
        Lit53 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 94362), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 94358), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 94353);
        Lit49 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 90277);
        Lit48 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 90254), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 90250), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 90245);
        Lit47 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 90277);
        Lit46 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 90254), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 90250), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 90245);
        Lit43 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 86193);
        Lit42 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 86170), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 86166), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 86161);
        Lit41 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 86193);
        Lit40 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 86170), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 86166), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 86161);
        Lit36 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 82094);
        Lit35 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 82071), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 82067), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 82062);
        Lit34 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 82094);
        Lit33 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 82071), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 82067), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 82062);
        Lit28 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 77997);
        Lit27 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 77974), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 77970), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 77965);
        Lit26 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 77997);
        Lit25 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 77974), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 77970), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 77965);
        Lit20 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 73898);
        Lit19 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 73875), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 73871), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 73866);
        Lit18 = PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 73898);
        Lit17 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 73875), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 73871), "/tmp/1726051910184_0.041805358258975134-0/youngandroidproject/../src/io/kodular/b2025dechablo/AsthmAlert/Screen1.yail", 73866);
    }

    public Screen1() {
        ModuleInfo.register(this);
        frame frame2 = new frame();
        frame2.$main = this;
        this.get$Mnsimple$Mnname = new ModuleMethod(frame2, 1, Lit521, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.android$Mnlog$Mnform = new ModuleMethod(frame2, 2, Lit522, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frame2, 3, Lit523, 8194);
        this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 4, Lit524, 8193);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 6, Lit525, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frame2, 7, Lit526, 8194);
        this.add$Mnto$Mnevents = new ModuleMethod(frame2, 8, Lit527, 8194);
        this.add$Mnto$Mncomponents = new ModuleMethod(frame2, 9, Lit528, 16388);
        this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frame2, 10, Lit529, 8194);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frame2, 11, Lit530, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.send$Mnerror = new ModuleMethod(frame2, 12, Lit531, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.process$Mnexception = new ModuleMethod(frame2, 13, "process-exception", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.dispatchEvent = new ModuleMethod(frame2, 14, Lit532, 16388);
        this.dispatchGenericEvent = new ModuleMethod(frame2, 15, Lit533, 16388);
        this.lookup$Mnhandler = new ModuleMethod(frame2, 16, Lit534, 8194);
        ModuleMethod moduleMethod = new ModuleMethod(frame2, 17, (Object) null, 0);
        moduleMethod.setProperty("source-location", "/tmp/runtime3380428371229514992.scm:620");
        lambda$Fn1 = moduleMethod;
        this.$define = new ModuleMethod(frame2, 18, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frame2, 19, (Object) null, 0);
        lambda$Fn3 = new ModuleMethod(frame2, 20, (Object) null, 0);
        lambda$Fn4 = new ModuleMethod(frame2, 21, (Object) null, 0);
        lambda$Fn5 = new ModuleMethod(frame2, 22, (Object) null, 0);
        lambda$Fn6 = new ModuleMethod(frame2, 23, (Object) null, 0);
        lambda$Fn7 = new ModuleMethod(frame2, 24, (Object) null, 0);
        lambda$Fn8 = new ModuleMethod(frame2, 25, (Object) null, 0);
        lambda$Fn9 = new ModuleMethod(frame2, 26, (Object) null, 0);
        lambda$Fn10 = new ModuleMethod(frame2, 27, (Object) null, 0);
        lambda$Fn11 = new ModuleMethod(frame2, 28, (Object) null, 0);
        lambda$Fn12 = new ModuleMethod(frame2, 29, (Object) null, 0);
        lambda$Fn13 = new ModuleMethod(frame2, 30, (Object) null, 0);
        lambda$Fn14 = new ModuleMethod(frame2, 31, (Object) null, 0);
        lambda$Fn15 = new ModuleMethod(frame2, 32, (Object) null, 0);
        lambda$Fn16 = new ModuleMethod(frame2, 33, (Object) null, 0);
        lambda$Fn17 = new ModuleMethod(frame2, 34, (Object) null, 0);
        lambda$Fn18 = new ModuleMethod(frame2, 35, (Object) null, 0);
        lambda$Fn19 = new ModuleMethod(frame2, 36, (Object) null, 0);
        lambda$Fn20 = new ModuleMethod(frame2, 37, (Object) null, 0);
        lambda$Fn21 = new ModuleMethod(frame2, 38, (Object) null, 0);
        lambda$Fn22 = new ModuleMethod(frame2, 39, (Object) null, 0);
        lambda$Fn23 = new ModuleMethod(frame2, 40, (Object) null, 0);
        lambda$Fn24 = new ModuleMethod(frame2, 41, (Object) null, 0);
        lambda$Fn25 = new ModuleMethod(frame2, 42, (Object) null, 0);
        this.Screen1$Initialize = new ModuleMethod(frame2, 43, Lit161, 0);
        lambda$Fn26 = new ModuleMethod(frame2, 44, (Object) null, 0);
        lambda$Fn27 = new ModuleMethod(frame2, 45, (Object) null, 0);
        lambda$Fn28 = new ModuleMethod(frame2, 46, (Object) null, 0);
        lambda$Fn29 = new ModuleMethod(frame2, 47, (Object) null, 0);
        lambda$Fn30 = new ModuleMethod(frame2, 48, (Object) null, 0);
        lambda$Fn31 = new ModuleMethod(frame2, 49, (Object) null, 0);
        lambda$Fn32 = new ModuleMethod(frame2, 50, (Object) null, 0);
        lambda$Fn33 = new ModuleMethod(frame2, 51, (Object) null, 0);
        lambda$Fn34 = new ModuleMethod(frame2, 52, (Object) null, 0);
        lambda$Fn35 = new ModuleMethod(frame2, 53, (Object) null, 0);
        lambda$Fn36 = new ModuleMethod(frame2, 54, (Object) null, 0);
        lambda$Fn37 = new ModuleMethod(frame2, 55, (Object) null, 0);
        lambda$Fn38 = new ModuleMethod(frame2, 56, (Object) null, 0);
        lambda$Fn39 = new ModuleMethod(frame2, 57, (Object) null, 0);
        lambda$Fn40 = new ModuleMethod(frame2, 58, (Object) null, 0);
        lambda$Fn41 = new ModuleMethod(frame2, 59, (Object) null, 0);
        this.Address$AfterPicking = new ModuleMethod(frame2, 60, Lit219, 0);
        lambda$Fn42 = new ModuleMethod(frame2, 61, (Object) null, 0);
        lambda$Fn43 = new ModuleMethod(frame2, 62, (Object) null, 0);
        lambda$Fn44 = new ModuleMethod(frame2, 63, (Object) null, 0);
        lambda$Fn45 = new ModuleMethod(frame2, 64, (Object) null, 0);
        lambda$Fn46 = new ModuleMethod(frame2, 65, (Object) null, 0);
        lambda$Fn47 = new ModuleMethod(frame2, 66, (Object) null, 0);
        lambda$Fn48 = new ModuleMethod(frame2, 67, (Object) null, 0);
        lambda$Fn49 = new ModuleMethod(frame2, 68, (Object) null, 0);
        lambda$Fn50 = new ModuleMethod(frame2, 69, (Object) null, 0);
        lambda$Fn51 = new ModuleMethod(frame2, 70, (Object) null, 0);
        lambda$Fn52 = new ModuleMethod(frame2, 71, (Object) null, 0);
        lambda$Fn53 = new ModuleMethod(frame2, 72, (Object) null, 0);
        lambda$Fn54 = new ModuleMethod(frame2, 73, (Object) null, 0);
        lambda$Fn55 = new ModuleMethod(frame2, 74, (Object) null, 0);
        lambda$Fn56 = new ModuleMethod(frame2, 75, (Object) null, 0);
        lambda$Fn57 = new ModuleMethod(frame2, 76, (Object) null, 0);
        lambda$Fn58 = new ModuleMethod(frame2, 77, (Object) null, 0);
        lambda$Fn59 = new ModuleMethod(frame2, 78, (Object) null, 0);
        lambda$Fn60 = new ModuleMethod(frame2, 79, (Object) null, 0);
        lambda$Fn61 = new ModuleMethod(frame2, 80, (Object) null, 0);
        lambda$Fn62 = new ModuleMethod(frame2, 81, (Object) null, 0);
        lambda$Fn63 = new ModuleMethod(frame2, 82, (Object) null, 0);
        lambda$Fn64 = new ModuleMethod(frame2, 83, (Object) null, 0);
        lambda$Fn65 = new ModuleMethod(frame2, 84, (Object) null, 0);
        lambda$Fn66 = new ModuleMethod(frame2, 85, (Object) null, 0);
        lambda$Fn67 = new ModuleMethod(frame2, 86, (Object) null, 0);
        lambda$Fn68 = new ModuleMethod(frame2, 87, (Object) null, 0);
        lambda$Fn69 = new ModuleMethod(frame2, 88, (Object) null, 0);
        lambda$Fn70 = new ModuleMethod(frame2, 89, (Object) null, 0);
        lambda$Fn71 = new ModuleMethod(frame2, 90, (Object) null, 0);
        lambda$Fn72 = new ModuleMethod(frame2, 91, (Object) null, 0);
        lambda$Fn73 = new ModuleMethod(frame2, 92, (Object) null, 0);
        lambda$Fn74 = new ModuleMethod(frame2, 93, (Object) null, 0);
        lambda$Fn75 = new ModuleMethod(frame2, 94, (Object) null, 0);
        lambda$Fn76 = new ModuleMethod(frame2, 95, (Object) null, 0);
        lambda$Fn77 = new ModuleMethod(frame2, 96, (Object) null, 0);
        lambda$Fn78 = new ModuleMethod(frame2, 97, (Object) null, 0);
        lambda$Fn79 = new ModuleMethod(frame2, 98, (Object) null, 0);
        lambda$Fn80 = new ModuleMethod(frame2, 99, (Object) null, 0);
        lambda$Fn81 = new ModuleMethod(frame2, 100, (Object) null, 0);
        lambda$Fn82 = new ModuleMethod(frame2, 101, (Object) null, 0);
        lambda$Fn83 = new ModuleMethod(frame2, 102, (Object) null, 0);
        lambda$Fn84 = new ModuleMethod(frame2, 103, (Object) null, 0);
        lambda$Fn85 = new ModuleMethod(frame2, 104, (Object) null, 0);
        lambda$Fn86 = new ModuleMethod(frame2, 105, (Object) null, 0);
        lambda$Fn87 = new ModuleMethod(frame2, 106, (Object) null, 0);
        lambda$Fn88 = new ModuleMethod(frame2, 107, (Object) null, 0);
        lambda$Fn89 = new ModuleMethod(frame2, 108, (Object) null, 0);
        lambda$Fn90 = new ModuleMethod(frame2, 109, (Object) null, 0);
        lambda$Fn91 = new ModuleMethod(frame2, 110, (Object) null, 0);
        lambda$Fn92 = new ModuleMethod(frame2, 111, (Object) null, 0);
        lambda$Fn93 = new ModuleMethod(frame2, 112, (Object) null, 0);
        lambda$Fn94 = new ModuleMethod(frame2, 113, (Object) null, 0);
        lambda$Fn95 = new ModuleMethod(frame2, 114, (Object) null, 0);
        lambda$Fn96 = new ModuleMethod(frame2, 115, (Object) null, 0);
        lambda$Fn97 = new ModuleMethod(frame2, 116, (Object) null, 0);
        lambda$Fn98 = new ModuleMethod(frame2, 117, (Object) null, 0);
        lambda$Fn99 = new ModuleMethod(frame2, 118, (Object) null, 0);
        lambda$Fn100 = new ModuleMethod(frame2, 119, (Object) null, 0);
        lambda$Fn101 = new ModuleMethod(frame2, 120, (Object) null, 0);
        lambda$Fn102 = new ModuleMethod(frame2, 121, (Object) null, 0);
        lambda$Fn103 = new ModuleMethod(frame2, 122, (Object) null, 0);
        lambda$Fn104 = new ModuleMethod(frame2, 123, (Object) null, 0);
        lambda$Fn105 = new ModuleMethod(frame2, 124, (Object) null, 0);
        lambda$Fn106 = new ModuleMethod(frame2, ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH, (Object) null, 0);
        lambda$Fn107 = new ModuleMethod(frame2, 126, (Object) null, 0);
        lambda$Fn108 = new ModuleMethod(frame2, 127, (Object) null, 0);
        lambda$Fn109 = new ModuleMethod(frame2, 128, (Object) null, 0);
        lambda$Fn110 = new ModuleMethod(frame2, 129, (Object) null, 0);
        lambda$Fn111 = new ModuleMethod(frame2, 130, (Object) null, 0);
        lambda$Fn112 = new ModuleMethod(frame2, 131, (Object) null, 0);
        lambda$Fn113 = new ModuleMethod(frame2, 132, (Object) null, 0);
        lambda$Fn114 = new ModuleMethod(frame2, 133, (Object) null, 0);
        lambda$Fn115 = new ModuleMethod(frame2, 134, (Object) null, 0);
        lambda$Fn116 = new ModuleMethod(frame2, 135, (Object) null, 0);
        lambda$Fn117 = new ModuleMethod(frame2, 136, (Object) null, 0);
        lambda$Fn118 = new ModuleMethod(frame2, 137, (Object) null, 0);
        lambda$Fn119 = new ModuleMethod(frame2, 138, (Object) null, 0);
        lambda$Fn120 = new ModuleMethod(frame2, 139, (Object) null, 0);
        lambda$Fn121 = new ModuleMethod(frame2, 140, (Object) null, 0);
        lambda$Fn122 = new ModuleMethod(frame2, 141, (Object) null, 0);
        lambda$Fn123 = new ModuleMethod(frame2, 142, (Object) null, 0);
        lambda$Fn124 = new ModuleMethod(frame2, 143, (Object) null, 0);
        lambda$Fn125 = new ModuleMethod(frame2, 144, (Object) null, 0);
        this.NavBar$ItemSelected = new ModuleMethod(frame2, 145, Lit415, 8194);
        lambda$Fn126 = new ModuleMethod(frame2, 146, (Object) null, 0);
        lambda$Fn127 = new ModuleMethod(frame2, 147, (Object) null, 0);
        lambda$Fn128 = new ModuleMethod(frame2, 148, (Object) null, 0);
        lambda$Fn129 = new ModuleMethod(frame2, 149, (Object) null, 0);
        lambda$Fn130 = new ModuleMethod(frame2, 150, (Object) null, 0);
        lambda$Fn131 = new ModuleMethod(frame2, 151, (Object) null, 0);
        lambda$Fn132 = new ModuleMethod(frame2, 152, (Object) null, 0);
        lambda$Fn133 = new ModuleMethod(frame2, 153, (Object) null, 0);
        lambda$Fn134 = new ModuleMethod(frame2, 154, (Object) null, 0);
        lambda$Fn135 = new ModuleMethod(frame2, 155, (Object) null, 0);
        lambda$Fn136 = new ModuleMethod(frame2, 156, (Object) null, 0);
        lambda$Fn137 = new ModuleMethod(frame2, 157, (Object) null, 0);
        lambda$Fn138 = new ModuleMethod(frame2, 158, (Object) null, 0);
        lambda$Fn139 = new ModuleMethod(frame2, 159, (Object) null, 0);
        lambda$Fn140 = new ModuleMethod(frame2, ComponentConstants.TEXTBOX_PREFERRED_WIDTH, (Object) null, 0);
        lambda$Fn141 = new ModuleMethod(frame2, 161, (Object) null, 0);
        lambda$Fn142 = new ModuleMethod(frame2, 162, (Object) null, 0);
        lambda$Fn143 = new ModuleMethod(frame2, 163, (Object) null, 0);
        lambda$Fn144 = new ModuleMethod(frame2, 164, (Object) null, 0);
        lambda$Fn145 = new ModuleMethod(frame2, 165, (Object) null, 0);
        this.Clock1$Timer = new ModuleMethod(frame2, 166, Lit468, 0);
        lambda$Fn146 = new ModuleMethod(frame2, 167, (Object) null, 0);
        lambda$Fn147 = new ModuleMethod(frame2, 168, (Object) null, 0);
        lambda$Fn148 = new ModuleMethod(frame2, 169, (Object) null, 0);
        lambda$Fn149 = new ModuleMethod(frame2, 170, (Object) null, 0);
        lambda$Fn150 = new ModuleMethod(frame2, 171, (Object) null, 0);
        lambda$Fn151 = new ModuleMethod(frame2, 172, (Object) null, 0);
        lambda$Fn152 = new ModuleMethod(frame2, 173, (Object) null, 0);
        lambda$Fn154 = new ModuleMethod(frame2, 174, (Object) null, 0);
        lambda$Fn155 = new ModuleMethod(frame2, 175, (Object) null, 0);
        lambda$Fn153 = new ModuleMethod(frame2, 176, (Object) null, 0);
        lambda$Fn156 = new ModuleMethod(frame2, 177, (Object) null, 0);
        lambda$Fn157 = new ModuleMethod(frame2, 178, (Object) null, 0);
        lambda$Fn158 = new ModuleMethod(frame2, 179, (Object) null, 0);
        this.VibrationClock$Timer = new ModuleMethod(frame2, 180, Lit499, 0);
        lambda$Fn159 = new ModuleMethod(frame2, 181, (Object) null, 0);
        lambda$Fn160 = new ModuleMethod(frame2, 182, (Object) null, 0);
        lambda$Fn161 = new ModuleMethod(frame2, 183, (Object) null, 0);
        lambda$Fn162 = new ModuleMethod(frame2, 184, (Object) null, 0);
        lambda$Fn163 = new ModuleMethod(frame2, 185, (Object) null, 0);
        lambda$Fn165 = new ModuleMethod(frame2, 186, (Object) null, 0);
        lambda$Fn166 = new ModuleMethod(frame2, 187, (Object) null, 0);
        lambda$Fn164 = new ModuleMethod(frame2, 188, (Object) null, 0);
        lambda$Fn167 = new ModuleMethod(frame2, FullScreenVideoUtil.FULLSCREEN_VIDEO_DIALOG_FLAG, (Object) null, 0);
        lambda$Fn168 = new ModuleMethod(frame2, FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_SEEK, (Object) null, 0);
        lambda$Fn169 = new ModuleMethod(frame2, FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PLAY, (Object) null, 0);
        this.NotifierClock$Timer = new ModuleMethod(frame2, FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PAUSE, Lit517, 0);
    }

    static String lambda10() {
        return "0";
    }

    static String lambda11() {
        return "0,0,0,0,0,0,0,0";
    }

    static Object lambda2() {
        return null;
    }

    static Boolean lambda4() {
        return Boolean.FALSE;
    }

    static String lambda6() {
        return "0";
    }

    static String lambda7() {
        return "";
    }

    static String lambda8() {
        return "0";
    }

    static String lambda9() {
        return "0";
    }

    public void androidLogForm(Object obj) {
    }

    public Object lookupInFormEnvironment(Symbol symbol) {
        return lookupInFormEnvironment(symbol, Boolean.FALSE);
    }

    public void run() {
        CallContext instance = CallContext.getInstance();
        Consumer consumer = instance.consumer;
        instance.consumer = VoidConsumer.instance;
        try {
            run(instance);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        ModuleBody.runCleanup(instance, th, consumer);
    }

    public final void run(CallContext callContext) {
        Consumer consumer = callContext.consumer;
        Object find = require.find("com.google.youngandroid.runtime");
        try {
            ((Runnable) find).run();
            this.$Stdebug$Mnform$St = Boolean.FALSE;
            SimpleSymbol simpleSymbol = Lit0;
            this.form$Mnenvironment = Environment.make(misc.symbol$To$String(simpleSymbol));
            FString stringAppend = strings.stringAppend(misc.symbol$To$String(simpleSymbol), "-global-vars");
            this.global$Mnvar$Mnenvironment = Environment.make(stringAppend == null ? null : stringAppend.toString());
            Screen1 = null;
            this.form$Mnname$Mnsymbol = simpleSymbol;
            this.events$Mnto$Mnregister = LList.Empty;
            this.components$Mnto$Mncreate = LList.Empty;
            this.global$Mnvars$Mnto$Mncreate = LList.Empty;
            this.form$Mndo$Mnafter$Mncreation = LList.Empty;
            Object find2 = require.find("com.google.youngandroid.runtime");
            try {
                ((Runnable) find2).run();
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit3, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list")), consumer);
                } else {
                    addToGlobalVars(Lit3, lambda$Fn2);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit4, Boolean.FALSE), consumer);
                } else {
                    addToGlobalVars(Lit4, lambda$Fn3);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit5, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list")), consumer);
                } else {
                    addToGlobalVars(Lit5, lambda$Fn4);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit6, "0"), consumer);
                } else {
                    addToGlobalVars(Lit6, lambda$Fn5);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit7, ""), consumer);
                } else {
                    addToGlobalVars(Lit7, lambda$Fn6);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit8, "0"), consumer);
                } else {
                    addToGlobalVars(Lit8, lambda$Fn7);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit9, "0"), consumer);
                } else {
                    addToGlobalVars(Lit9, lambda$Fn8);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit10, "0"), consumer);
                } else {
                    addToGlobalVars(Lit10, lambda$Fn9);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit11, "0,0,0,0,0,0,0,0"), consumer);
                } else {
                    addToGlobalVars(Lit11, lambda$Fn10);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit12, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list")), consumer);
                } else {
                    addToGlobalVars(Lit12, lambda$Fn11);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit13, runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit14, Lit15, Lit16), Lit17, "make a list")), Lit18, "make-color")), consumer);
                } else {
                    addToGlobalVars(Lit13, lambda$Fn12);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit21, runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit22, Lit23, Lit24), Lit25, "make a list")), Lit26, "make-color")), consumer);
                } else {
                    addToGlobalVars(Lit21, lambda$Fn13);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit29, runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit30, Lit31, Lit32), Lit33, "make a list")), Lit34, "make-color")), consumer);
                } else {
                    addToGlobalVars(Lit29, lambda$Fn14);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit37, runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit30, Lit38, Lit39), Lit40, "make a list")), Lit41, "make-color")), consumer);
                } else {
                    addToGlobalVars(Lit37, lambda$Fn15);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    SimpleSymbol simpleSymbol2 = Lit44;
                    ModuleMethod moduleMethod = runtime.make$Mncolor;
                    ModuleMethod moduleMethod2 = runtime.make$Mnyail$Mnlist;
                    IntNum intNum = Lit30;
                    IntNum intNum2 = Lit45;
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol2, runtime.callYailPrimitive(moduleMethod, LList.list1(runtime.callYailPrimitive(moduleMethod2, LList.list3(intNum, intNum2, intNum2), Lit46, "make a list")), Lit47, "make-color")), consumer);
                } else {
                    addToGlobalVars(Lit44, lambda$Fn16);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit50, runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit30, Lit51, Lit52), Lit53, "make a list")), Lit54, "make-color")), consumer);
                } else {
                    addToGlobalVars(Lit50, lambda$Fn17);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit57, runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit30, Lit24, Lit58), Lit59, "make a list")), Lit60, "make-color")), consumer);
                } else {
                    addToGlobalVars(Lit57, lambda$Fn18);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit63, runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit30, Lit64, Lit65), Lit66, "make a list")), Lit67, "make-color")), consumer);
                } else {
                    addToGlobalVars(Lit63, lambda$Fn19);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit70, runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit71, Lit72, Lit73), Lit74, "make a list")), Lit75, "make-color")), consumer);
                } else {
                    addToGlobalVars(Lit70, lambda$Fn20);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit78, runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit79, Lit52, Lit15), Lit80, "make a list")), Lit81, "make-color")), consumer);
                } else {
                    addToGlobalVars(Lit78, lambda$Fn21);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit84, runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit14, Lit85, Lit86), Lit87, "make a list")), Lit88, "make-color")), consumer);
                } else {
                    addToGlobalVars(Lit84, lambda$Fn22);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit91, runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit92, Lit93, Lit94), Lit95, "make a list")), Lit96, "make-color")), consumer);
                } else {
                    addToGlobalVars(Lit91, lambda$Fn23);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit99, runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit100, Lit101, Lit102), Lit103, "make a list")), Lit104, "make-color")), consumer);
                } else {
                    addToGlobalVars(Lit99, lambda$Fn24);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    SimpleSymbol simpleSymbol3 = Lit107;
                    IntNum intNum3 = Lit108;
                    SimpleSymbol simpleSymbol4 = Lit109;
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol3, intNum3, simpleSymbol4);
                    SimpleSymbol simpleSymbol5 = Lit110;
                    SimpleSymbol simpleSymbol6 = Lit111;
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol5, "About this Application", simpleSymbol6);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit112, Lit113, simpleSymbol4);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol4);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit116, "5430271999475712", simpleSymbol6);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit117, "AsthmAlert", simpleSymbol6);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit119, simpleSymbol4);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit120, "fade", simpleSymbol6);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit121, Lit122, simpleSymbol4);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit123, "fade", simpleSymbol6);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit124, Lit125, simpleSymbol4);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit126, Lit127, simpleSymbol4);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit128, AlgorithmIdentifiers.NONE, simpleSymbol6);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit129, "portrait", simpleSymbol6);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit130, "AsthmAlertIcon.png", simpleSymbol6);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit131, "AsthmAlert", simpleSymbol6);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit132, Lit133, simpleSymbol4);
                    Values.writeValues(runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit134, "CanvaSansBold.ttf", simpleSymbol6), consumer);
                } else {
                    addToFormDoAfterCreation(new Promise(lambda$Fn25));
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit161, this.Screen1$Initialize);
                } else {
                    addToFormEnvironment(Lit161, this.Screen1$Initialize);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Screen1", "Initialize");
                } else {
                    addToEvents(simpleSymbol, Lit162);
                }
                this.PaddingTop = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit163, Lit164, lambda$Fn26), consumer);
                } else {
                    addToComponents(simpleSymbol, Lit168, Lit164, lambda$Fn27);
                }
                this.Devices = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit169, Lit139, lambda$Fn28), consumer);
                } else {
                    addToComponents(simpleSymbol, Lit171, Lit139, lambda$Fn29);
                }
                this.Image1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit139, Lit172, Lit173, lambda$Fn30), consumer);
                } else {
                    addToComponents(Lit139, Lit176, Lit173, lambda$Fn31);
                }
                this.Space1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit139, Lit177, Lit178, lambda$Fn32), consumer);
                } else {
                    addToComponents(Lit139, Lit179, Lit178, lambda$Fn33);
                }
                this.Vertical_Arrangement1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit139, Lit180, Lit181, lambda$Fn34), consumer);
                } else {
                    addToComponents(Lit139, Lit184, Lit181, lambda$Fn35);
                }
                this.Label1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit181, Lit185, Lit186, lambda$Fn36), consumer);
                } else {
                    addToComponents(Lit181, Lit198, Lit186, lambda$Fn37);
                }
                this.Space2_copy = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit139, Lit199, Lit200, lambda$Fn38), consumer);
                } else {
                    addToComponents(Lit139, Lit201, Lit200, lambda$Fn39);
                }
                this.Horizontal_Arrangement1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit139, Lit202, Lit203, Boolean.FALSE), consumer);
                } else {
                    addToComponents(Lit139, Lit204, Lit203, Boolean.FALSE);
                }
                this.Address = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit203, Lit205, Lit145, lambda$Fn40), consumer);
                } else {
                    addToComponents(Lit203, Lit214, Lit145, lambda$Fn41);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit219, this.Address$AfterPicking);
                } else {
                    addToFormEnvironment(Lit219, this.Address$AfterPicking);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Address", "AfterPicking");
                } else {
                    addToEvents(Lit145, Lit220);
                }
                this.Name = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit203, Lit221, Lit222, lambda$Fn42), consumer);
                } else {
                    addToComponents(Lit203, Lit225, Lit222, lambda$Fn43);
                }
                this.Home = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit226, Lit135, lambda$Fn44), consumer);
                } else {
                    addToComponents(simpleSymbol, Lit228, Lit135, lambda$Fn45);
                }
                this.Horizontal_Arrangement2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit135, Lit229, Lit230, lambda$Fn46), consumer);
                } else {
                    addToComponents(Lit135, Lit233, Lit230, lambda$Fn47);
                }
                this.Vertical_Arrangement2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit230, Lit234, Lit235, lambda$Fn48), consumer);
                } else {
                    addToComponents(Lit230, Lit238, Lit235, lambda$Fn49);
                }
                this.aqi = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit235, Lit239, Lit240, lambda$Fn50), consumer);
                } else {
                    addToComponents(Lit235, Lit243, Lit240, lambda$Fn51);
                }
                this.aqiVal = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit235, Lit244, Lit245, lambda$Fn52), consumer);
                } else {
                    addToComponents(Lit235, Lit248, Lit245, lambda$Fn53);
                }
                this.Vertical_Arrangement3 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit230, Lit249, Lit250, lambda$Fn54), consumer);
                } else {
                    addToComponents(Lit230, Lit252, Lit250, lambda$Fn55);
                }
                this.healthConcern = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit250, Lit253, Lit254, lambda$Fn56), consumer);
                } else {
                    addToComponents(Lit250, Lit256, Lit254, lambda$Fn57);
                }
                this.very = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit250, Lit257, Lit258, lambda$Fn58), consumer);
                } else {
                    addToComponents(Lit250, Lit260, Lit258, lambda$Fn59);
                }
                this.healthConcernVal = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit250, Lit261, Lit262, lambda$Fn60), consumer);
                } else {
                    addToComponents(Lit250, Lit265, Lit262, lambda$Fn61);
                }
                this.forSensGroups = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit250, Lit266, Lit267, lambda$Fn62), consumer);
                } else {
                    addToComponents(Lit250, Lit269, Lit267, lambda$Fn63);
                }
                this.Space3 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit135, Lit270, Lit271, lambda$Fn64), consumer);
                } else {
                    addToComponents(Lit135, Lit272, Lit271, lambda$Fn65);
                }
                this.Horizontal_Arrangement4 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit135, Lit273, Lit274, lambda$Fn66), consumer);
                } else {
                    addToComponents(Lit135, Lit276, Lit274, lambda$Fn67);
                }
                this.Horizontal_Arrangement5 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit274, Lit277, Lit278, lambda$Fn68), consumer);
                } else {
                    addToComponents(Lit274, Lit280, Lit278, lambda$Fn69);
                }
                this.Space4 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit278, Lit281, Lit282, lambda$Fn70), consumer);
                } else {
                    addToComponents(Lit278, Lit283, Lit282, lambda$Fn71);
                }
                this.Label2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit278, Lit284, Lit285, lambda$Fn72), consumer);
                } else {
                    addToComponents(Lit278, Lit287, Lit285, lambda$Fn73);
                }
                this.Vertical_Arrangement5 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit274, Lit288, Lit289, lambda$Fn74), consumer);
                } else {
                    addToComponents(Lit274, Lit292, Lit289, lambda$Fn75);
                }
                this.Label3 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit289, Lit293, Lit294, lambda$Fn76), consumer);
                } else {
                    addToComponents(Lit289, Lit296, Lit294, lambda$Fn77);
                }
                this.Vertical_Arrangement6 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit274, Lit297, Lit298, lambda$Fn78), consumer);
                } else {
                    addToComponents(Lit274, Lit300, Lit298, lambda$Fn79);
                }
                this.Label4 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit298, Lit301, Lit302, lambda$Fn80), consumer);
                } else {
                    addToComponents(Lit298, Lit304, Lit302, lambda$Fn81);
                }
                this.Space3_copy = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit135, Lit305, Lit306, lambda$Fn82), consumer);
                } else {
                    addToComponents(Lit135, Lit307, Lit306, lambda$Fn83);
                }
                this.Horizontal_Arrangement3 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit135, Lit308, Lit309, lambda$Fn84), consumer);
                } else {
                    addToComponents(Lit135, Lit310, Lit309, lambda$Fn85);
                }
                this.measures = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit309, Lit311, Lit312, lambda$Fn86), consumer);
                } else {
                    addToComponents(Lit309, Lit320, Lit312, lambda$Fn87);
                }
                this.values = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit309, Lit321, Lit322, lambda$Fn88), consumer);
                } else {
                    addToComponents(Lit309, Lit327, Lit322, lambda$Fn89);
                }
                this.unit = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit309, Lit328, Lit329, lambda$Fn90), consumer);
                } else {
                    addToComponents(Lit309, Lit334, Lit329, lambda$Fn91);
                }
                this.Info = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit335, Lit138, lambda$Fn92), consumer);
                } else {
                    addToComponents(simpleSymbol, Lit337, Lit138, lambda$Fn93);
                }
                this.Vertical_Arrangement1_copy = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit138, Lit338, Lit339, lambda$Fn94), consumer);
                } else {
                    addToComponents(Lit138, Lit341, Lit339, lambda$Fn95);
                }
                this.InstructionsLabel = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit339, Lit342, Lit343, lambda$Fn96), consumer);
                } else {
                    addToComponents(Lit339, Lit346, Lit343, lambda$Fn97);
                }
                this.Space2_copy1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit138, Lit347, Lit348, lambda$Fn98), consumer);
                } else {
                    addToComponents(Lit138, Lit349, Lit348, lambda$Fn99);
                }
                this.Horizontal_Arrangement6 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit138, Lit350, Lit351, lambda$Fn100), consumer);
                } else {
                    addToComponents(Lit138, Lit352, Lit351, lambda$Fn101);
                }
                this.Numbers = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit351, Lit353, Lit354, lambda$Fn102), consumer);
                } else {
                    addToComponents(Lit351, Lit360, Lit354, lambda$Fn103);
                }
                this.Instructions = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit351, Lit361, Lit147, lambda$Fn104), consumer);
                } else {
                    addToComponents(Lit351, Lit365, Lit147, lambda$Fn105);
                }
                this.Space2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit138, Lit366, Lit367, lambda$Fn106), consumer);
                } else {
                    addToComponents(Lit138, Lit368, Lit367, lambda$Fn107);
                }
                this.Vertical_Arrangement1_copy_copy = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit138, Lit369, Lit370, lambda$Fn108), consumer);
                } else {
                    addToComponents(Lit138, Lit372, Lit370, lambda$Fn109);
                }
                this.AboutLabel = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit370, Lit373, Lit374, lambda$Fn110), consumer);
                } else {
                    addToComponents(Lit370, Lit377, Lit374, lambda$Fn111);
                }
                this.Space2_copy2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit138, Lit378, Lit379, lambda$Fn112), consumer);
                } else {
                    addToComponents(Lit138, Lit380, Lit379, lambda$Fn113);
                }
                this.About = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit138, Lit381, Lit151, lambda$Fn114), consumer);
                } else {
                    addToComponents(Lit138, Lit386, Lit151, lambda$Fn115);
                }
                this.Space2_copy2_copy = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit138, Lit387, Lit388, lambda$Fn116), consumer);
                } else {
                    addToComponents(Lit138, Lit389, Lit388, lambda$Fn117);
                }
                this.About2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit138, Lit390, Lit153, lambda$Fn118), consumer);
                } else {
                    addToComponents(Lit138, Lit396, Lit153, lambda$Fn119);
                }
                this.Spacing = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit397, Lit398, lambda$Fn120), consumer);
                } else {
                    addToComponents(simpleSymbol, Lit399, Lit398, lambda$Fn121);
                }
                this.PaddingBottom = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit400, Lit401, lambda$Fn122), consumer);
                } else {
                    addToComponents(simpleSymbol, Lit402, Lit401, lambda$Fn123);
                }
                this.NavBar = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit403, Lit155, lambda$Fn124), consumer);
                } else {
                    addToComponents(simpleSymbol, Lit409, Lit155, lambda$Fn125);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit415, this.NavBar$ItemSelected);
                } else {
                    addToFormEnvironment(Lit415, this.NavBar$ItemSelected);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "NavBar", "ItemSelected");
                } else {
                    addToEvents(Lit155, Lit416);
                }
                this.Bluetooth_Client1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit417, Lit216, Boolean.FALSE), consumer);
                } else {
                    addToComponents(simpleSymbol, Lit418, Lit216, Boolean.FALSE);
                }
                this.Sound1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit419, Lit420, lambda$Fn126), consumer);
                } else {
                    addToComponents(simpleSymbol, Lit423, Lit420, lambda$Fn127);
                }
                this.Clock1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit424, Lit425, lambda$Fn128), consumer);
                } else {
                    addToComponents(simpleSymbol, Lit428, Lit425, lambda$Fn129);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit468, this.Clock1$Timer);
                } else {
                    addToFormEnvironment(Lit468, this.Clock1$Timer);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Clock1", "Timer");
                } else {
                    addToEvents(Lit425, Lit469);
                }
                this.Notifier1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit470, Lit471, lambda$Fn146), consumer);
                } else {
                    addToComponents(simpleSymbol, Lit480, Lit471, lambda$Fn147);
                }
                this.VibrationClock = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit481, Lit482, lambda$Fn148), consumer);
                } else {
                    addToComponents(simpleSymbol, Lit484, Lit482, lambda$Fn149);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit499, this.VibrationClock$Timer);
                } else {
                    addToFormEnvironment(Lit499, this.VibrationClock$Timer);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "VibrationClock", "Timer");
                } else {
                    addToEvents(Lit482, Lit469);
                }
                this.NotifierClock = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit500, Lit501, lambda$Fn159), consumer);
                } else {
                    addToComponents(simpleSymbol, Lit503, Lit501, lambda$Fn160);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit517, this.NotifierClock$Timer);
                } else {
                    addToFormEnvironment(Lit517, this.NotifierClock$Timer);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "NotifierClock", "Timer");
                } else {
                    addToEvents(Lit501, Lit469);
                }
                this.Decoration1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit518, Lit519, Boolean.FALSE), consumer);
                } else {
                    addToComponents(simpleSymbol, Lit520, Lit519, Boolean.FALSE);
                }
                runtime.initRuntime();
            } catch (ClassCastException e) {
                throw new WrongType(e, "java.lang.Runnable.run()", 1, find2);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "java.lang.Runnable.run()", 1, find);
        }
    }

    static Object lambda3() {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list");
    }

    static Object lambda5() {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list");
    }

    static Object lambda12() {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list");
    }

    static Object lambda13() {
        return runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit14, Lit15, Lit16), Lit19, "make a list")), Lit20, "make-color");
    }

    static Object lambda14() {
        return runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit22, Lit23, Lit24), Lit27, "make a list")), Lit28, "make-color");
    }

    static Object lambda15() {
        return runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit30, Lit31, Lit32), Lit35, "make a list")), Lit36, "make-color");
    }

    static Object lambda16() {
        return runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit30, Lit38, Lit39), Lit42, "make a list")), Lit43, "make-color");
    }

    static Object lambda17() {
        ModuleMethod moduleMethod = runtime.make$Mncolor;
        ModuleMethod moduleMethod2 = runtime.make$Mnyail$Mnlist;
        IntNum intNum = Lit30;
        IntNum intNum2 = Lit45;
        return runtime.callYailPrimitive(moduleMethod, LList.list1(runtime.callYailPrimitive(moduleMethod2, LList.list3(intNum, intNum2, intNum2), Lit48, "make a list")), Lit49, "make-color");
    }

    static Object lambda18() {
        return runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit30, Lit51, Lit52), Lit55, "make a list")), Lit56, "make-color");
    }

    static Object lambda19() {
        return runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit30, Lit24, Lit58), Lit61, "make a list")), Lit62, "make-color");
    }

    static Object lambda20() {
        return runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit30, Lit64, Lit65), Lit68, "make a list")), Lit69, "make-color");
    }

    static Object lambda21() {
        return runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit71, Lit72, Lit73), Lit76, "make a list")), Lit77, "make-color");
    }

    static Object lambda22() {
        return runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit79, Lit52, Lit15), Lit82, "make a list")), Lit83, "make-color");
    }

    static Object lambda23() {
        return runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit14, Lit85, Lit86), Lit89, "make a list")), Lit90, "make-color");
    }

    static Object lambda24() {
        return runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit92, Lit93, Lit94), Lit97, "make a list")), Lit98, "make-color");
    }

    static Object lambda25() {
        return runtime.callYailPrimitive(runtime.make$Mncolor, LList.list1(runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3(Lit100, Lit101, Lit102), Lit105, "make a list")), Lit106, "make-color");
    }

    static Object lambda26() {
        SimpleSymbol simpleSymbol = Lit0;
        SimpleSymbol simpleSymbol2 = Lit107;
        IntNum intNum = Lit108;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit110;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "About this Application", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit112, Lit113, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit116, "5430271999475712", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit117, "AsthmAlert", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit119, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit120, "fade", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit121, Lit122, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit123, "fade", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit124, Lit125, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit126, Lit127, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit128, AlgorithmIdentifiers.NONE, simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit129, "portrait", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit130, "AsthmAlertIcon.png", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit131, "AsthmAlert", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit132, Lit133, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit134, "CanvaSansBold.ttf", simpleSymbol5);
    }

    public Object Screen1$Initialize() {
        runtime.setThisForm();
        SimpleSymbol simpleSymbol = Lit135;
        SimpleSymbol simpleSymbol2 = Lit136;
        Boolean bool = Boolean.FALSE;
        SimpleSymbol simpleSymbol3 = Lit137;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, bool, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit138;
        runtime.setAndCoerceProperty$Ex(simpleSymbol4, simpleSymbol2, Boolean.FALSE, simpleSymbol3);
        SimpleSymbol simpleSymbol5 = Lit139;
        SimpleSymbol simpleSymbol6 = Lit140;
        AddOp addOp = AddOp.$Mn;
        SimpleSymbol simpleSymbol7 = Lit0;
        Object property$1 = runtime.getProperty$1(simpleSymbol7, simpleSymbol6);
        IntNum intNum = Lit141;
        Object callYailPrimitive = runtime.callYailPrimitive(addOp, LList.list2(property$1, intNum), Lit142, "-");
        SimpleSymbol simpleSymbol8 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol5, simpleSymbol6, callYailPrimitive, simpleSymbol8);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, runtime.callYailPrimitive(AddOp.$Mn, LList.list2(runtime.getProperty$1(simpleSymbol7, simpleSymbol6), intNum), Lit143, "-"), simpleSymbol8);
        runtime.setAndCoerceProperty$Ex(simpleSymbol4, simpleSymbol6, runtime.callYailPrimitive(AddOp.$Mn, LList.list2(runtime.getProperty$1(simpleSymbol7, simpleSymbol6), intNum), Lit144, "-"), simpleSymbol8);
        runtime.setAndCoerceProperty$Ex(Lit145, simpleSymbol6, runtime.callYailPrimitive(AddOp.$Mn, LList.list2(runtime.getProperty$1(simpleSymbol7, simpleSymbol6), intNum), Lit146, "-"), simpleSymbol8);
        SimpleSymbol simpleSymbol9 = Lit147;
        SimpleSymbol simpleSymbol10 = Lit148;
        Object callYailPrimitive2 = runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list4("Ensure that your device's Bluetooth and AsthmAlert is on", "From the Devices tab, select AsthmAlert to connect to the device", "The connection attempt is successful if the Bluetooth icon changed", "Switch to the Home tab to observe the data being collected"), Lit149, "make a list");
        SimpleSymbol simpleSymbol11 = Lit150;
        runtime.setAndCoerceProperty$Ex(simpleSymbol9, simpleSymbol10, callYailPrimitive2, simpleSymbol11);
        runtime.setAndCoerceProperty$Ex(Lit151, simpleSymbol10, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list1("AsthmAlert aims to provide a low-cost preventative solution to asthma, especially for lower-income families. Our beneficiaries include asthmatic individuals, particularly children and those in developing countries where asthma care may be inadequate."), Lit152, "make a list"), simpleSymbol11);
        runtime.setAndCoerceProperty$Ex(Lit153, simpleSymbol10, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list2("The project proponents include: Jaeden Miguel Castro, Dane Ezekiel Hablo, and Rafael Paulimo", "The project supervisors are: Sir Jason Alcarez and Sir Bimbo Alexis Galit"), Lit154, "make a list"), simpleSymbol11);
        SimpleSymbol simpleSymbol12 = Lit155;
        SimpleSymbol simpleSymbol13 = Lit156;
        runtime.callComponentMethod(simpleSymbol12, simpleSymbol13, LList.list3(Lit157, "Devices", "devices.png"), Lit158);
        runtime.callComponentMethod(simpleSymbol12, simpleSymbol13, LList.list3(Lit115, "Home", "home.png"), Lit159);
        return runtime.callComponentMethod(simpleSymbol12, simpleSymbol13, LList.list3(Lit113, "Info", "info.png"), Lit160);
    }

    static Object lambda27() {
        SimpleSymbol simpleSymbol = Lit164;
        SimpleSymbol simpleSymbol2 = Lit165;
        IntNum intNum = Lit166;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda28() {
        SimpleSymbol simpleSymbol = Lit164;
        SimpleSymbol simpleSymbol2 = Lit165;
        IntNum intNum = Lit166;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda29() {
        SimpleSymbol simpleSymbol = Lit139;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit170, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit165;
        IntNum intNum2 = Lit167;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum2, simpleSymbol3);
    }

    static Object lambda30() {
        SimpleSymbol simpleSymbol = Lit139;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit170, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit165;
        IntNum intNum2 = Lit167;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum2, simpleSymbol3);
    }

    static Object lambda31() {
        SimpleSymbol simpleSymbol = Lit173;
        SimpleSymbol simpleSymbol2 = Lit165;
        IntNum intNum = Lit174;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit175, "bluetoothDisabled.png", Lit111);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum, simpleSymbol3);
    }

    static Object lambda32() {
        SimpleSymbol simpleSymbol = Lit173;
        SimpleSymbol simpleSymbol2 = Lit165;
        IntNum intNum = Lit174;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit175, "bluetoothDisabled.png", Lit111);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum, simpleSymbol3);
    }

    static Object lambda33() {
        SimpleSymbol simpleSymbol = Lit178;
        SimpleSymbol simpleSymbol2 = Lit165;
        IntNum intNum = Lit166;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda34() {
        SimpleSymbol simpleSymbol = Lit178;
        SimpleSymbol simpleSymbol2 = Lit165;
        IntNum intNum = Lit166;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda35() {
        SimpleSymbol simpleSymbol = Lit181;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit182, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit183, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda36() {
        SimpleSymbol simpleSymbol = Lit181;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit182, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit183, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda37() {
        SimpleSymbol simpleSymbol = Lit186;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit187;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit188, Lit189, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, Lit133, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit191;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansBold.ttf", simpleSymbol5);
        SimpleSymbol simpleSymbol6 = Lit192;
        Boolean bool = Boolean.FALSE;
        SimpleSymbol simpleSymbol7 = Lit137;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, bool, simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit193, Boolean.FALSE, simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Available Devices", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit197, simpleSymbol3);
    }

    static Object lambda38() {
        SimpleSymbol simpleSymbol = Lit186;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit187;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit188, Lit189, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, Lit133, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit191;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansBold.ttf", simpleSymbol5);
        SimpleSymbol simpleSymbol6 = Lit192;
        Boolean bool = Boolean.FALSE;
        SimpleSymbol simpleSymbol7 = Lit137;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, bool, simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit193, Boolean.FALSE, simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Available Devices", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit197, simpleSymbol3);
    }

    static Object lambda39() {
        return runtime.setAndCoerceProperty$Ex(Lit200, Lit165, Lit113, Lit109);
    }

    static Object lambda40() {
        return runtime.setAndCoerceProperty$Ex(Lit200, Lit165, Lit113, Lit109);
    }

    static Object lambda41() {
        SimpleSymbol simpleSymbol = Lit145;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit206;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit208, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", Lit111);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit211, Lit166, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit212, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit189, simpleSymbol3);
    }

    static Object lambda42() {
        SimpleSymbol simpleSymbol = Lit145;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit206;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit208, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", Lit111);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit211, Lit166, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit212, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit189, simpleSymbol3);
    }

    public Object Address$AfterPicking() {
        runtime.setThisForm();
        SimpleSymbol simpleSymbol = Lit145;
        SimpleSymbol simpleSymbol2 = Lit215;
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, runtime.callComponentMethod(Lit216, Lit217, LList.list1(runtime.getProperty$1(simpleSymbol, simpleSymbol2)), Lit218), Lit111);
    }

    static Object lambda43() {
        SimpleSymbol simpleSymbol = Lit222;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit223;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit190;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", Lit111);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, intNum2, simpleSymbol3);
        SimpleSymbol simpleSymbol5 = Lit211;
        IntNum intNum3 = Lit166;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol5, intNum3, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit224, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, intNum3, simpleSymbol3);
    }

    static Object lambda44() {
        SimpleSymbol simpleSymbol = Lit222;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit223;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit190;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", Lit111);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, intNum2, simpleSymbol3);
        SimpleSymbol simpleSymbol5 = Lit211;
        IntNum intNum3 = Lit166;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol5, intNum3, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit224, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, intNum3, simpleSymbol3);
    }

    static Object lambda45() {
        SimpleSymbol simpleSymbol = Lit135;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit227, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit165;
        IntNum intNum2 = Lit167;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit136, Boolean.FALSE, Lit137);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum2, simpleSymbol3);
    }

    static Object lambda46() {
        SimpleSymbol simpleSymbol = Lit135;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit227, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit165;
        IntNum intNum2 = Lit167;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit136, Boolean.FALSE, Lit137);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum2, simpleSymbol3);
    }

    static Object lambda47() {
        SimpleSymbol simpleSymbol = Lit230;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit231;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit232, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda48() {
        SimpleSymbol simpleSymbol = Lit230;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit231;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit232, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda49() {
        SimpleSymbol simpleSymbol = Lit235;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit236, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit167, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit237, simpleSymbol3);
    }

    static Object lambda50() {
        SimpleSymbol simpleSymbol = Lit235;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit236, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit167, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit237, simpleSymbol3);
    }

    static Object lambda51() {
        SimpleSymbol simpleSymbol = Lit240;
        SimpleSymbol simpleSymbol2 = Lit188;
        IntNum intNum = Lit241;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, Lit133, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit191;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansBold.ttf", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "AQI", simpleSymbol5);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit242, simpleSymbol3);
    }

    static Object lambda52() {
        SimpleSymbol simpleSymbol = Lit240;
        SimpleSymbol simpleSymbol2 = Lit188;
        IntNum intNum = Lit241;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, Lit133, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit191;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansBold.ttf", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "AQI", simpleSymbol5);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit242, simpleSymbol3);
    }

    static Object lambda53() {
        SimpleSymbol simpleSymbol = Lit245;
        SimpleSymbol simpleSymbol2 = Lit246;
        Boolean bool = Boolean.TRUE;
        SimpleSymbol simpleSymbol3 = Lit137;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, bool, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit188;
        IntNum intNum = Lit72;
        SimpleSymbol simpleSymbol5 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, Lit133, simpleSymbol5);
        SimpleSymbol simpleSymbol6 = Lit191;
        SimpleSymbol simpleSymbol7 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, "CanvaSansBold.ttf", simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "50", simpleSymbol7);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit247, simpleSymbol5);
    }

    static Object lambda54() {
        SimpleSymbol simpleSymbol = Lit245;
        SimpleSymbol simpleSymbol2 = Lit246;
        Boolean bool = Boolean.TRUE;
        SimpleSymbol simpleSymbol3 = Lit137;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, bool, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit188;
        IntNum intNum = Lit72;
        SimpleSymbol simpleSymbol5 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, Lit133, simpleSymbol5);
        SimpleSymbol simpleSymbol6 = Lit191;
        SimpleSymbol simpleSymbol7 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, "CanvaSansBold.ttf", simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "50", simpleSymbol7);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit247, simpleSymbol5);
    }

    static Object lambda55() {
        SimpleSymbol simpleSymbol = Lit250;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit251, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit165;
        IntNum intNum2 = Lit167;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum2, simpleSymbol3);
    }

    static Object lambda56() {
        SimpleSymbol simpleSymbol = Lit250;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit251, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit165;
        IntNum intNum2 = Lit167;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum2, simpleSymbol3);
    }

    static Object lambda57() {
        SimpleSymbol simpleSymbol = Lit254;
        SimpleSymbol simpleSymbol2 = Lit191;
        SimpleSymbol simpleSymbol3 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "CanvaSansBold.ttf", simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Health Concern", simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit195;
        IntNum intNum = Lit157;
        SimpleSymbol simpleSymbol5 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit255, simpleSymbol5);
    }

    static Object lambda58() {
        SimpleSymbol simpleSymbol = Lit254;
        SimpleSymbol simpleSymbol2 = Lit191;
        SimpleSymbol simpleSymbol3 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "CanvaSansBold.ttf", simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Health Concern", simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit195;
        IntNum intNum = Lit157;
        SimpleSymbol simpleSymbol5 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit255, simpleSymbol5);
    }

    static Object lambda59() {
        SimpleSymbol simpleSymbol = Lit258;
        SimpleSymbol simpleSymbol2 = Lit188;
        IntNum intNum = Lit241;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit191;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansBold.ttf", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Very", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit259, simpleSymbol3);
    }

    static Object lambda60() {
        SimpleSymbol simpleSymbol = Lit258;
        SimpleSymbol simpleSymbol2 = Lit188;
        IntNum intNum = Lit241;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit191;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansBold.ttf", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Very", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit259, simpleSymbol3);
    }

    /* compiled from: Screen1.yail */
    public class frame extends ModuleBody {
        Screen1 $main;

        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            int i = moduleMethod.selector;
            if (i == 1) {
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            } else if (i == 2) {
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            } else if (i != 4) {
                if (i != 6) {
                    switch (i) {
                        case 11:
                            callContext.value1 = obj;
                            callContext.proc = moduleMethod;
                            callContext.pc = 1;
                            return 0;
                        case 12:
                            callContext.value1 = obj;
                            callContext.proc = moduleMethod;
                            callContext.pc = 1;
                            return 0;
                        case 13:
                            if (!(obj instanceof Screen1)) {
                                return -786431;
                            }
                            callContext.value1 = obj;
                            callContext.proc = moduleMethod;
                            callContext.pc = 1;
                            return 0;
                        default:
                            return super.match1(moduleMethod, obj, callContext);
                    }
                } else if (!(obj instanceof Symbol)) {
                    return -786431;
                } else {
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                }
            } else if (!(obj instanceof Symbol)) {
                return -786431;
            } else {
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }

        public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
            int i = moduleMethod.selector;
            if (i != 3) {
                if (i != 4) {
                    if (i != 7) {
                        if (i == 8) {
                            callContext.value1 = obj;
                            callContext.value2 = obj2;
                            callContext.proc = moduleMethod;
                            callContext.pc = 2;
                            return 0;
                        } else if (i == 10) {
                            callContext.value1 = obj;
                            callContext.value2 = obj2;
                            callContext.proc = moduleMethod;
                            callContext.pc = 2;
                            return 0;
                        } else if (i == 16) {
                            callContext.value1 = obj;
                            callContext.value2 = obj2;
                            callContext.proc = moduleMethod;
                            callContext.pc = 2;
                            return 0;
                        } else if (i != 145) {
                            return super.match2(moduleMethod, obj, obj2, callContext);
                        } else {
                            callContext.value1 = obj;
                            callContext.value2 = obj2;
                            callContext.proc = moduleMethod;
                            callContext.pc = 2;
                            return 0;
                        }
                    } else if (!(obj instanceof Symbol)) {
                        return -786431;
                    } else {
                        callContext.value1 = obj;
                        callContext.value2 = obj2;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                } else if (!(obj instanceof Symbol)) {
                    return -786431;
                } else {
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                }
            } else if (!(obj instanceof Symbol)) {
                return -786431;
            } else {
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }

        public int match4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4, CallContext callContext) {
            int i = moduleMethod.selector;
            if (i == 9) {
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            } else if (i != 14) {
                if (i != 15) {
                    return super.match4(moduleMethod, obj, obj2, obj3, obj4, callContext);
                }
                if (!(obj instanceof Screen1)) {
                    return -786431;
                }
                callContext.value1 = obj;
                if (!(obj2 instanceof Component)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                if (!(obj3 instanceof String)) {
                    return -786429;
                }
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            } else if (!(obj instanceof Screen1)) {
                return -786431;
            } else {
                callContext.value1 = obj;
                if (!(obj2 instanceof Component)) {
                    return -786430;
                }
                callContext.value2 = obj2;
                if (!(obj3 instanceof String)) {
                    return -786429;
                }
                callContext.value3 = obj3;
                if (!(obj4 instanceof String)) {
                    return -786428;
                }
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
        }

        public Object apply1(ModuleMethod moduleMethod, Object obj) {
            int i = moduleMethod.selector;
            if (i == 1) {
                return this.$main.getSimpleName(obj);
            }
            if (i == 2) {
                this.$main.androidLogForm(obj);
                return Values.empty;
            } else if (i == 4) {
                try {
                    return this.$main.lookupInFormEnvironment((Symbol) obj);
                } catch (ClassCastException e) {
                    throw new WrongType(e, "lookup-in-form-environment", 1, obj);
                }
            } else if (i != 6) {
                switch (i) {
                    case 11:
                        this.$main.addToFormDoAfterCreation(obj);
                        return Values.empty;
                    case 12:
                        this.$main.sendError(obj);
                        return Values.empty;
                    case 13:
                        this.$main.processException(obj);
                        return Values.empty;
                    default:
                        return super.apply1(moduleMethod, obj);
                }
            } else {
                try {
                    return this.$main.isBoundInFormEnvironment((Symbol) obj) ? Boolean.TRUE : Boolean.FALSE;
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "is-bound-in-form-environment", 1, obj);
                }
            }
        }

        public Object apply4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4) {
            int i = moduleMethod.selector;
            if (i != 9) {
                boolean z = true;
                if (i == 14) {
                    try {
                        try {
                            try {
                                try {
                                    return this.$main.dispatchEvent((Component) obj, (String) obj2, (String) obj3, (Object[]) obj4) ? Boolean.TRUE : Boolean.FALSE;
                                } catch (ClassCastException e) {
                                    throw new WrongType(e, "dispatchEvent", 4, obj4);
                                }
                            } catch (ClassCastException e2) {
                                throw new WrongType(e2, "dispatchEvent", 3, obj3);
                            }
                        } catch (ClassCastException e3) {
                            throw new WrongType(e3, "dispatchEvent", 2, obj2);
                        }
                    } catch (ClassCastException e4) {
                        throw new WrongType(e4, "dispatchEvent", 1, obj);
                    }
                } else if (i != 15) {
                    return super.apply4(moduleMethod, obj, obj2, obj3, obj4);
                } else {
                    Screen1 screen1 = this.$main;
                    try {
                        Component component = (Component) obj;
                        try {
                            String str = (String) obj2;
                            try {
                                if (obj3 == Boolean.FALSE) {
                                    z = false;
                                }
                                try {
                                    screen1.dispatchGenericEvent(component, str, z, (Object[]) obj4);
                                    return Values.empty;
                                } catch (ClassCastException e5) {
                                    throw new WrongType(e5, "dispatchGenericEvent", 4, obj4);
                                }
                            } catch (ClassCastException e6) {
                                throw new WrongType(e6, "dispatchGenericEvent", 3, obj3);
                            }
                        } catch (ClassCastException e7) {
                            throw new WrongType(e7, "dispatchGenericEvent", 2, obj2);
                        }
                    } catch (ClassCastException e8) {
                        throw new WrongType(e8, "dispatchGenericEvent", 1, obj);
                    }
                }
            } else {
                this.$main.addToComponents(obj, obj2, obj3, obj4);
                return Values.empty;
            }
        }

        public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
            int i = moduleMethod.selector;
            if (i == 3) {
                try {
                    this.$main.addToFormEnvironment((Symbol) obj, obj2);
                    return Values.empty;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "add-to-form-environment", 1, obj);
                }
            } else if (i == 4) {
                try {
                    return this.$main.lookupInFormEnvironment((Symbol) obj, obj2);
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "lookup-in-form-environment", 1, obj);
                }
            } else if (i == 7) {
                try {
                    this.$main.addToGlobalVarEnvironment((Symbol) obj, obj2);
                    return Values.empty;
                } catch (ClassCastException e3) {
                    throw new WrongType(e3, "add-to-global-var-environment", 1, obj);
                }
            } else if (i == 8) {
                this.$main.addToEvents(obj, obj2);
                return Values.empty;
            } else if (i == 10) {
                this.$main.addToGlobalVars(obj, obj2);
                return Values.empty;
            } else if (i == 16) {
                return this.$main.lookupHandler(obj, obj2);
            } else {
                if (i != 145) {
                    return super.apply2(moduleMethod, obj, obj2);
                }
                return this.$main.NavBar$ItemSelected(obj, obj2);
            }
        }

        public Object apply0(ModuleMethod moduleMethod) {
            switch (moduleMethod.selector) {
                case 17:
                    return Screen1.lambda2();
                case 18:
                    this.$main.$define();
                    return Values.empty;
                case 19:
                    return Screen1.lambda3();
                case 20:
                    return Screen1.lambda4();
                case 21:
                    return Screen1.lambda5();
                case 22:
                    return Screen1.lambda6();
                case 23:
                    return Screen1.lambda7();
                case 24:
                    return Screen1.lambda8();
                case 25:
                    return Screen1.lambda9();
                case 26:
                    return Screen1.lambda10();
                case 27:
                    return Screen1.lambda11();
                case 28:
                    return Screen1.lambda12();
                case 29:
                    return Screen1.lambda13();
                case 30:
                    return Screen1.lambda14();
                case 31:
                    return Screen1.lambda15();
                case 32:
                    return Screen1.lambda16();
                case 33:
                    return Screen1.lambda17();
                case 34:
                    return Screen1.lambda18();
                case 35:
                    return Screen1.lambda19();
                case 36:
                    return Screen1.lambda20();
                case 37:
                    return Screen1.lambda21();
                case 38:
                    return Screen1.lambda22();
                case 39:
                    return Screen1.lambda23();
                case 40:
                    return Screen1.lambda24();
                case 41:
                    return Screen1.lambda25();
                case 42:
                    return Screen1.lambda26();
                case 43:
                    return this.$main.Screen1$Initialize();
                case 44:
                    return Screen1.lambda27();
                case 45:
                    return Screen1.lambda28();
                case 46:
                    return Screen1.lambda29();
                case 47:
                    return Screen1.lambda30();
                case 48:
                    return Screen1.lambda31();
                case 49:
                    return Screen1.lambda32();
                case 50:
                    return Screen1.lambda33();
                case 51:
                    return Screen1.lambda34();
                case 52:
                    return Screen1.lambda35();
                case 53:
                    return Screen1.lambda36();
                case 54:
                    return Screen1.lambda37();
                case 55:
                    return Screen1.lambda38();
                case 56:
                    return Screen1.lambda39();
                case 57:
                    return Screen1.lambda40();
                case 58:
                    return Screen1.lambda41();
                case 59:
                    return Screen1.lambda42();
                case 60:
                    return this.$main.Address$AfterPicking();
                case 61:
                    return Screen1.lambda43();
                case 62:
                    return Screen1.lambda44();
                case 63:
                    return Screen1.lambda45();
                case 64:
                    return Screen1.lambda46();
                case 65:
                    return Screen1.lambda47();
                case 66:
                    return Screen1.lambda48();
                case 67:
                    return Screen1.lambda49();
                case 68:
                    return Screen1.lambda50();
                case 69:
                    return Screen1.lambda51();
                case 70:
                    return Screen1.lambda52();
                case 71:
                    return Screen1.lambda53();
                case 72:
                    return Screen1.lambda54();
                case 73:
                    return Screen1.lambda55();
                case 74:
                    return Screen1.lambda56();
                case 75:
                    return Screen1.lambda57();
                case 76:
                    return Screen1.lambda58();
                case 77:
                    return Screen1.lambda59();
                case 78:
                    return Screen1.lambda60();
                case 79:
                    return Screen1.lambda61();
                case 80:
                    return Screen1.lambda62();
                case 81:
                    return Screen1.lambda63();
                case 82:
                    return Screen1.lambda64();
                case 83:
                    return Screen1.lambda65();
                case 84:
                    return Screen1.lambda66();
                case 85:
                    return Screen1.lambda67();
                case 86:
                    return Screen1.lambda68();
                case 87:
                    return Screen1.lambda69();
                case 88:
                    return Screen1.lambda70();
                case 89:
                    return Screen1.lambda71();
                case 90:
                    return Screen1.lambda72();
                case 91:
                    return Screen1.lambda73();
                case 92:
                    return Screen1.lambda74();
                case 93:
                    return Screen1.lambda75();
                case 94:
                    return Screen1.lambda76();
                case 95:
                    return Screen1.lambda77();
                case 96:
                    return Screen1.lambda78();
                case 97:
                    return Screen1.lambda79();
                case 98:
                    return Screen1.lambda80();
                case 99:
                    return Screen1.lambda81();
                case 100:
                    return Screen1.lambda82();
                case 101:
                    return Screen1.lambda83();
                case 102:
                    return Screen1.lambda84();
                case 103:
                    return Screen1.lambda85();
                case 104:
                    return Screen1.lambda86();
                case 105:
                    return Screen1.lambda87();
                case 106:
                    return Screen1.lambda88();
                case 107:
                    return Screen1.lambda89();
                case 108:
                    return Screen1.lambda90();
                case 109:
                    return Screen1.lambda91();
                case 110:
                    return Screen1.lambda92();
                case 111:
                    return Screen1.lambda93();
                case 112:
                    return Screen1.lambda94();
                case 113:
                    return Screen1.lambda95();
                case 114:
                    return Screen1.lambda96();
                case 115:
                    return Screen1.lambda97();
                case 116:
                    return Screen1.lambda98();
                case 117:
                    return Screen1.lambda99();
                case 118:
                    return Screen1.lambda100();
                case 119:
                    return Screen1.lambda101();
                case 120:
                    return Screen1.lambda102();
                case 121:
                    return Screen1.lambda103();
                case 122:
                    return Screen1.lambda104();
                case 123:
                    return Screen1.lambda105();
                case 124:
                    return Screen1.lambda106();
                case ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH /*125*/:
                    return Screen1.lambda107();
                case 126:
                    return Screen1.lambda108();
                case 127:
                    return Screen1.lambda109();
                case 128:
                    return Screen1.lambda110();
                case 129:
                    return Screen1.lambda111();
                case 130:
                    return Screen1.lambda112();
                case 131:
                    return Screen1.lambda113();
                case 132:
                    return Screen1.lambda114();
                case 133:
                    return Screen1.lambda115();
                case 134:
                    return Screen1.lambda116();
                case 135:
                    return Screen1.lambda117();
                case 136:
                    return Screen1.lambda118();
                case 137:
                    return Screen1.lambda119();
                case 138:
                    return Screen1.lambda120();
                case 139:
                    return Screen1.lambda121();
                case 140:
                    return Screen1.lambda122();
                case 141:
                    return Screen1.lambda123();
                case 142:
                    return Screen1.lambda124();
                case 143:
                    return Screen1.lambda125();
                case 144:
                    return Screen1.lambda126();
                case 146:
                    return Screen1.lambda127();
                case 147:
                    return Screen1.lambda128();
                case 148:
                    return Screen1.lambda129();
                case 149:
                    return Screen1.lambda130();
                case 150:
                    return Screen1.lambda131();
                case 151:
                    return Screen1.lambda132();
                case 152:
                    return Screen1.lambda133();
                case 153:
                    return Screen1.lambda134();
                case 154:
                    return Screen1.lambda135();
                case 155:
                    return Screen1.lambda136();
                case 156:
                    return Screen1.lambda137();
                case 157:
                    return Screen1.lambda138();
                case 158:
                    return Screen1.lambda139();
                case 159:
                    return Screen1.lambda140();
                case ComponentConstants.TEXTBOX_PREFERRED_WIDTH:
                    return Screen1.lambda141();
                case 161:
                    return Screen1.lambda142();
                case 162:
                    return Screen1.lambda143();
                case 163:
                    return Screen1.lambda144();
                case 164:
                    return Screen1.lambda145();
                case 165:
                    return Screen1.lambda146();
                case 166:
                    return this.$main.Clock1$Timer();
                case 167:
                    return Screen1.lambda147();
                case 168:
                    return Screen1.lambda148();
                case 169:
                    return Screen1.lambda149();
                case 170:
                    return Screen1.lambda150();
                case 171:
                    return Screen1.lambda151();
                case 172:
                    return Screen1.lambda152();
                case 173:
                    return Screen1.lambda153();
                case 174:
                    return Screen1.lambda155();
                case 175:
                    return Screen1.lambda156();
                case 176:
                    return Screen1.lambda154();
                case 177:
                    return Screen1.lambda157();
                case 178:
                    return Screen1.lambda158();
                case 179:
                    return Screen1.lambda159();
                case 180:
                    return this.$main.VibrationClock$Timer();
                case 181:
                    return Screen1.lambda160();
                case 182:
                    return Screen1.lambda161();
                case 183:
                    return Screen1.lambda162();
                case 184:
                    return Screen1.lambda163();
                case 185:
                    return Screen1.lambda164();
                case 186:
                    return Screen1.lambda166();
                case 187:
                    return Screen1.lambda167();
                case 188:
                    return Screen1.lambda165();
                case FullScreenVideoUtil.FULLSCREEN_VIDEO_DIALOG_FLAG:
                    return Screen1.lambda168();
                case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_SEEK:
                    return Screen1.lambda169();
                case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PLAY:
                    return Screen1.lambda170();
                case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PAUSE:
                    return this.$main.NotifierClock$Timer();
                default:
                    return super.apply0(moduleMethod);
            }
        }

        public int match0(ModuleMethod moduleMethod, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 17:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 18:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 19:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 20:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 21:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 22:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 23:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 24:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 25:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 26:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 27:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 28:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 29:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 30:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 31:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 32:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 33:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 34:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 35:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 36:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 37:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 38:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 39:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 40:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 41:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 42:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 43:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 44:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 45:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 46:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 47:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 48:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 49:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 50:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 51:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 52:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 53:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 54:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 55:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 56:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 57:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 58:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 59:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 60:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 61:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 62:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 63:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 64:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 65:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 66:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 67:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 68:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 69:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 70:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 71:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 72:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 73:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 74:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 75:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 76:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 77:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 78:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 79:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 80:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 81:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 82:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 83:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 84:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 85:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 86:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 87:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 88:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 89:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 90:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 91:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 92:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 93:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 94:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 95:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 96:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 97:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 98:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 99:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 100:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 101:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 102:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 103:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 104:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 105:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 106:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 107:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 108:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 109:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 110:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 111:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 112:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 113:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 114:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 115:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 116:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 117:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 118:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 119:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 120:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 121:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 122:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 123:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 124:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH /*125*/:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 126:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 127:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 128:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 129:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 130:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 131:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 132:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 133:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 134:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 135:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 136:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 137:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 138:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 139:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 140:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 141:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 142:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 143:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 144:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 146:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 147:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 148:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 149:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 150:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 151:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 152:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 153:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 154:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 155:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 156:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 157:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 158:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 159:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case ComponentConstants.TEXTBOX_PREFERRED_WIDTH:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 161:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 162:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 163:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 164:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 165:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 166:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 167:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 168:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 169:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 170:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 171:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 172:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 173:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 174:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 175:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 176:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 177:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 178:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 179:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 180:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 181:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 182:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 183:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 184:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 185:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 186:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 187:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 188:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case FullScreenVideoUtil.FULLSCREEN_VIDEO_DIALOG_FLAG:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_SEEK:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PLAY:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PAUSE:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                default:
                    return super.match0(moduleMethod, callContext);
            }
        }
    }

    static Object lambda61() {
        SimpleSymbol simpleSymbol = Lit262;
        SimpleSymbol simpleSymbol2 = Lit246;
        Boolean bool = Boolean.TRUE;
        SimpleSymbol simpleSymbol3 = Lit137;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, bool, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit188;
        IntNum intNum = Lit263;
        SimpleSymbol simpleSymbol5 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        SimpleSymbol simpleSymbol6 = Lit191;
        SimpleSymbol simpleSymbol7 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, "CanvaSansBold.ttf", simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Hazardous", simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol5);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit264, simpleSymbol5);
    }

    static Object lambda62() {
        SimpleSymbol simpleSymbol = Lit262;
        SimpleSymbol simpleSymbol2 = Lit246;
        Boolean bool = Boolean.TRUE;
        SimpleSymbol simpleSymbol3 = Lit137;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, bool, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit188;
        IntNum intNum = Lit263;
        SimpleSymbol simpleSymbol5 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        SimpleSymbol simpleSymbol6 = Lit191;
        SimpleSymbol simpleSymbol7 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, "CanvaSansBold.ttf", simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Hazardous", simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol5);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit264, simpleSymbol5);
    }

    static Object lambda63() {
        SimpleSymbol simpleSymbol = Lit267;
        SimpleSymbol simpleSymbol2 = Lit188;
        IntNum intNum = Lit241;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit191;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansBold.ttf", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "For Sensitive Groups", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit268, simpleSymbol3);
    }

    static Object lambda64() {
        SimpleSymbol simpleSymbol = Lit267;
        SimpleSymbol simpleSymbol2 = Lit188;
        IntNum intNum = Lit241;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit191;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansBold.ttf", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "For Sensitive Groups", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit268, simpleSymbol3);
    }

    static Object lambda65() {
        return runtime.setAndCoerceProperty$Ex(Lit271, Lit165, Lit166, Lit109);
    }

    static Object lambda66() {
        return runtime.setAndCoerceProperty$Ex(Lit271, Lit165, Lit166, Lit109);
    }

    static Object lambda67() {
        SimpleSymbol simpleSymbol = Lit274;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit275, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit183, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda68() {
        SimpleSymbol simpleSymbol = Lit274;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit275, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit183, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda69() {
        SimpleSymbol simpleSymbol = Lit278;
        SimpleSymbol simpleSymbol2 = Lit114;
        IntNum intNum = Lit115;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit167, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit279, simpleSymbol3);
    }

    static Object lambda70() {
        SimpleSymbol simpleSymbol = Lit278;
        SimpleSymbol simpleSymbol2 = Lit114;
        IntNum intNum = Lit115;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit167, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit279, simpleSymbol3);
    }

    static Object lambda71() {
        SimpleSymbol simpleSymbol = Lit282;
        SimpleSymbol simpleSymbol2 = Lit165;
        IntNum intNum = Lit167;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit166, simpleSymbol3);
    }

    static Object lambda72() {
        SimpleSymbol simpleSymbol = Lit282;
        SimpleSymbol simpleSymbol2 = Lit165;
        IntNum intNum = Lit167;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit166, simpleSymbol3);
    }

    static Object lambda73() {
        SimpleSymbol simpleSymbol = Lit285;
        SimpleSymbol simpleSymbol2 = Lit188;
        IntNum intNum = Lit189;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit191;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansBold.ttf", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Measure", simpleSymbol5);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit286, simpleSymbol3);
    }

    static Object lambda74() {
        SimpleSymbol simpleSymbol = Lit285;
        SimpleSymbol simpleSymbol2 = Lit188;
        IntNum intNum = Lit189;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit191;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansBold.ttf", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Measure", simpleSymbol5);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit286, simpleSymbol3);
    }

    static Object lambda75() {
        SimpleSymbol simpleSymbol = Lit289;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit290, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit167, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit291, simpleSymbol3);
    }

    static Object lambda76() {
        SimpleSymbol simpleSymbol = Lit289;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit290, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit167, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit291, simpleSymbol3);
    }

    static Object lambda77() {
        SimpleSymbol simpleSymbol = Lit294;
        SimpleSymbol simpleSymbol2 = Lit191;
        SimpleSymbol simpleSymbol3 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "CanvaSansBold.ttf", simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Reading", simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit195;
        IntNum intNum = Lit157;
        SimpleSymbol simpleSymbol5 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit295, simpleSymbol5);
    }

    static Object lambda78() {
        SimpleSymbol simpleSymbol = Lit294;
        SimpleSymbol simpleSymbol2 = Lit191;
        SimpleSymbol simpleSymbol3 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "CanvaSansBold.ttf", simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Reading", simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit195;
        IntNum intNum = Lit157;
        SimpleSymbol simpleSymbol5 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit295, simpleSymbol5);
    }

    static Object lambda79() {
        SimpleSymbol simpleSymbol = Lit298;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit299, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit165;
        IntNum intNum2 = Lit167;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum2, simpleSymbol3);
    }

    static Object lambda80() {
        SimpleSymbol simpleSymbol = Lit298;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit299, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit165;
        IntNum intNum2 = Lit167;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum2, simpleSymbol3);
    }

    static Object lambda81() {
        SimpleSymbol simpleSymbol = Lit302;
        SimpleSymbol simpleSymbol2 = Lit191;
        SimpleSymbol simpleSymbol3 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "CanvaSansBold.ttf", simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Unit", simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit195;
        IntNum intNum = Lit157;
        SimpleSymbol simpleSymbol5 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit303, simpleSymbol5);
    }

    static Object lambda82() {
        SimpleSymbol simpleSymbol = Lit302;
        SimpleSymbol simpleSymbol2 = Lit191;
        SimpleSymbol simpleSymbol3 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "CanvaSansBold.ttf", simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit192, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Unit", simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit195;
        IntNum intNum = Lit157;
        SimpleSymbol simpleSymbol5 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit303, simpleSymbol5);
    }

    static Object lambda83() {
        return runtime.setAndCoerceProperty$Ex(Lit306, Lit165, Lit113, Lit109);
    }

    static Object lambda84() {
        return runtime.setAndCoerceProperty$Ex(Lit306, Lit165, Lit113, Lit109);
    }

    static Object lambda85() {
        SimpleSymbol simpleSymbol = Lit309;
        SimpleSymbol simpleSymbol2 = Lit165;
        IntNum intNum = Lit167;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum, simpleSymbol3);
    }

    static Object lambda86() {
        SimpleSymbol simpleSymbol = Lit309;
        SimpleSymbol simpleSymbol2 = Lit165;
        IntNum intNum = Lit167;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum, simpleSymbol3);
    }

    static Object lambda87() {
        SimpleSymbol simpleSymbol = Lit312;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit313;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit314, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        SimpleSymbol simpleSymbol5 = Lit315;
        SimpleSymbol simpleSymbol6 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol5, "VOC Index, NOx Index, Temperature, Temperature Change, Humidity, PM 1.0, PM 2.5, PM 4, PM 10", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit316, Lit317, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit318, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit189, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit319, simpleSymbol3);
    }

    static Object lambda88() {
        SimpleSymbol simpleSymbol = Lit312;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit313;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit314, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        SimpleSymbol simpleSymbol5 = Lit315;
        SimpleSymbol simpleSymbol6 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol5, "VOC Index, NOx Index, Temperature, Temperature Change, Humidity, PM 1.0, PM 2.5, PM 4, PM 10", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit316, Lit317, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit318, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit189, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit319, simpleSymbol3);
    }

    static Object lambda89() {
        SimpleSymbol simpleSymbol = Lit322;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit323;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit324, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        SimpleSymbol simpleSymbol5 = Lit315;
        SimpleSymbol simpleSymbol6 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol5, "0,0,0,0,0,0,0,0,0", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit325, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit189, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit326, simpleSymbol3);
    }

    static Object lambda90() {
        SimpleSymbol simpleSymbol = Lit322;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit323;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit324, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        SimpleSymbol simpleSymbol5 = Lit315;
        SimpleSymbol simpleSymbol6 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol5, "0,0,0,0,0,0,0,0,0", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit325, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit189, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit326, simpleSymbol3);
    }

    static Object lambda91() {
        SimpleSymbol simpleSymbol = Lit329;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit330;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit331, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        SimpleSymbol simpleSymbol5 = Lit315;
        SimpleSymbol simpleSymbol6 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol5, " , , °C, °C, %HF, μg/m³, μg/m³, μg/m³, μg/m³", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit332, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit333, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit189, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda92() {
        SimpleSymbol simpleSymbol = Lit329;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit330;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit331, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        SimpleSymbol simpleSymbol5 = Lit315;
        SimpleSymbol simpleSymbol6 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol5, " , , °C, °C, %HF, μg/m³, μg/m³, μg/m³, μg/m³", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit332, Boolean.FALSE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit333, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit189, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda93() {
        SimpleSymbol simpleSymbol = Lit138;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit336, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit165;
        IntNum intNum2 = Lit167;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit136, Boolean.FALSE, Lit137);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum2, simpleSymbol3);
    }

    static Object lambda94() {
        SimpleSymbol simpleSymbol = Lit138;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit336, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit165;
        IntNum intNum2 = Lit167;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit136, Boolean.FALSE, Lit137);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum2, simpleSymbol3);
    }

    static Object lambda95() {
        SimpleSymbol simpleSymbol = Lit339;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit340, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit183, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda96() {
        SimpleSymbol simpleSymbol = Lit339;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit340, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit183, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda97() {
        SimpleSymbol simpleSymbol = Lit343;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit344;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit188, Lit189, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, Lit133, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit191;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansBold.ttf", simpleSymbol5);
        SimpleSymbol simpleSymbol6 = Lit192;
        Boolean bool = Boolean.FALSE;
        SimpleSymbol simpleSymbol7 = Lit137;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, bool, simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit193, Boolean.FALSE, simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Instructions", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit345, simpleSymbol3);
    }

    static Object lambda98() {
        SimpleSymbol simpleSymbol = Lit343;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit344;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit188, Lit189, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, Lit133, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit191;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansBold.ttf", simpleSymbol5);
        SimpleSymbol simpleSymbol6 = Lit192;
        Boolean bool = Boolean.FALSE;
        SimpleSymbol simpleSymbol7 = Lit137;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, bool, simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit193, Boolean.FALSE, simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "Instructions", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit345, simpleSymbol3);
    }

    static Object lambda100() {
        return runtime.setAndCoerceProperty$Ex(Lit348, Lit165, Lit113, Lit109);
    }

    static Object lambda99() {
        return runtime.setAndCoerceProperty$Ex(Lit348, Lit165, Lit113, Lit109);
    }

    static Object lambda101() {
        return runtime.setAndCoerceProperty$Ex(Lit351, Lit140, Lit167, Lit109);
    }

    static Object lambda102() {
        return runtime.setAndCoerceProperty$Ex(Lit351, Lit140, Lit167, Lit109);
    }

    static Object lambda103() {
        SimpleSymbol simpleSymbol = Lit354;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit355;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit356, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        SimpleSymbol simpleSymbol5 = Lit315;
        SimpleSymbol simpleSymbol6 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol5, "1.,2.,3.,4.", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, Lit357, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit211, Lit166, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit358, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit359, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit183, simpleSymbol3);
    }

    static Object lambda104() {
        SimpleSymbol simpleSymbol = Lit354;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit355;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit356, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        SimpleSymbol simpleSymbol5 = Lit315;
        SimpleSymbol simpleSymbol6 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol5, "1.,2.,3.,4.", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", simpleSymbol6);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, Lit357, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit211, Lit166, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit358, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit359, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit183, simpleSymbol3);
    }

    static Object lambda105() {
        SimpleSymbol simpleSymbol = Lit147;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit362;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit363, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", Lit111);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, Lit357, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit211, Lit166, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit364, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit189, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda106() {
        SimpleSymbol simpleSymbol = Lit147;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit362;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit363, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", Lit111);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, Lit357, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit211, Lit166, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit364, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit189, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda107() {
        return runtime.setAndCoerceProperty$Ex(Lit367, Lit165, Lit166, Lit109);
    }

    static Object lambda108() {
        return runtime.setAndCoerceProperty$Ex(Lit367, Lit165, Lit166, Lit109);
    }

    static Object lambda109() {
        SimpleSymbol simpleSymbol = Lit370;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit371, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit183, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda110() {
        SimpleSymbol simpleSymbol = Lit370;
        SimpleSymbol simpleSymbol2 = Lit112;
        IntNum intNum = Lit113;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit114, Lit115, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit118, Lit371, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit165, Lit183, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda111() {
        SimpleSymbol simpleSymbol = Lit374;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit375;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit188, Lit189, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, Lit133, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit191;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansBold.ttf", simpleSymbol5);
        SimpleSymbol simpleSymbol6 = Lit192;
        Boolean bool = Boolean.FALSE;
        SimpleSymbol simpleSymbol7 = Lit137;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, bool, simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit193, Boolean.FALSE, simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "About", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit376, simpleSymbol3);
    }

    static Object lambda112() {
        SimpleSymbol simpleSymbol = Lit374;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit375;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit188, Lit189, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, Lit133, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit191;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansBold.ttf", simpleSymbol5);
        SimpleSymbol simpleSymbol6 = Lit192;
        Boolean bool = Boolean.FALSE;
        SimpleSymbol simpleSymbol7 = Lit137;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, bool, simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit193, Boolean.FALSE, simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit194, "About", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit376, simpleSymbol3);
    }

    static Object lambda113() {
        return runtime.setAndCoerceProperty$Ex(Lit379, Lit165, Lit113, Lit109);
    }

    static Object lambda114() {
        return runtime.setAndCoerceProperty$Ex(Lit379, Lit165, Lit113, Lit109);
    }

    static Object lambda115() {
        SimpleSymbol simpleSymbol = Lit151;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit382;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit383, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", Lit111);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, Lit384, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit211, Lit166, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit385, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit189, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda116() {
        SimpleSymbol simpleSymbol = Lit151;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit382;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit383, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", Lit111);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, Lit384, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit211, Lit166, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit385, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit189, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda117() {
        return runtime.setAndCoerceProperty$Ex(Lit388, Lit165, Lit113, Lit109);
    }

    static Object lambda118() {
        return runtime.setAndCoerceProperty$Ex(Lit388, Lit165, Lit113, Lit109);
    }

    static Object lambda119() {
        SimpleSymbol simpleSymbol = Lit153;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit391;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit392, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", Lit111);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, Lit393, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit394, Boolean.TRUE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit211, Lit166, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit395, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit189, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda120() {
        SimpleSymbol simpleSymbol = Lit153;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit391;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit207, Lit392, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit209;
        IntNum intNum2 = Lit133;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit190, intNum2, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit191, "CanvaSansRegular.ttf", Lit111);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit210, Lit393, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit394, Boolean.TRUE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit211, Lit166, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit195, Lit157, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit395, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit213, Lit189, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda121() {
        SimpleSymbol simpleSymbol = Lit398;
        SimpleSymbol simpleSymbol2 = Lit165;
        IntNum intNum = Lit167;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit136, Boolean.FALSE, Lit137);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum, simpleSymbol3);
    }

    static Object lambda122() {
        SimpleSymbol simpleSymbol = Lit398;
        SimpleSymbol simpleSymbol2 = Lit165;
        IntNum intNum = Lit167;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit136, Boolean.FALSE, Lit137);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, intNum, simpleSymbol3);
    }

    static Object lambda123() {
        SimpleSymbol simpleSymbol = Lit401;
        SimpleSymbol simpleSymbol2 = Lit165;
        IntNum intNum = Lit166;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda124() {
        SimpleSymbol simpleSymbol = Lit401;
        SimpleSymbol simpleSymbol2 = Lit165;
        IntNum intNum = Lit166;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit140, Lit167, simpleSymbol3);
    }

    static Object lambda125() {
        SimpleSymbol simpleSymbol = Lit155;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit404;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit405, Lit406, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit407, Lit408, simpleSymbol3);
    }

    static Object lambda126() {
        SimpleSymbol simpleSymbol = Lit155;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit404;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit405, Lit406, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit407, Lit408, simpleSymbol3);
    }

    public Object NavBar$ItemSelected(Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        SimpleSymbol simpleSymbol;
        SimpleSymbol simpleSymbol2;
        SimpleSymbol simpleSymbol3;
        Boolean bool;
        SimpleSymbol simpleSymbol4;
        Boolean bool2;
        SimpleSymbol simpleSymbol5;
        Boolean bool3;
        runtime.sanitizeComponentData(obj);
        Object sanitizeComponentData = runtime.sanitizeComponentData(obj2);
        runtime.setThisForm();
        ModuleMethod moduleMethod = runtime.yail$Mnequal$Qu;
        boolean z = sanitizeComponentData instanceof Package;
        if (z) {
            obj3 = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit410), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj3 = sanitizeComponentData;
        }
        if (runtime.callYailPrimitive(moduleMethod, LList.list2(obj3, "Devices"), Lit411, "=") != Boolean.FALSE) {
            SimpleSymbol simpleSymbol6 = Lit139;
            simpleSymbol = Lit136;
            Boolean bool4 = Boolean.TRUE;
            simpleSymbol2 = Lit137;
            runtime.setAndCoerceProperty$Ex(simpleSymbol6, simpleSymbol, bool4, simpleSymbol2);
            simpleSymbol5 = Lit135;
            bool3 = Boolean.FALSE;
        } else {
            ModuleMethod moduleMethod2 = runtime.yail$Mnequal$Qu;
            if (z) {
                obj4 = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit410), " is not bound in the current context"), "Unbound Variable");
            } else {
                obj4 = sanitizeComponentData;
            }
            if (runtime.callYailPrimitive(moduleMethod2, LList.list2(obj4, "Home"), Lit412, "=") == Boolean.FALSE) {
                ModuleMethod moduleMethod3 = runtime.yail$Mnequal$Qu;
                if (z) {
                    sanitizeComponentData = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit410), " is not bound in the current context"), "Unbound Variable");
                }
                if (runtime.callYailPrimitive(moduleMethod3, LList.list2(sanitizeComponentData, "Info"), Lit414, "=") == Boolean.FALSE) {
                    return Values.empty;
                }
                SimpleSymbol simpleSymbol7 = Lit139;
                simpleSymbol = Lit136;
                Boolean bool5 = Boolean.FALSE;
                simpleSymbol2 = Lit137;
                runtime.setAndCoerceProperty$Ex(simpleSymbol7, simpleSymbol, bool5, simpleSymbol2);
                runtime.setAndCoerceProperty$Ex(Lit135, simpleSymbol, Boolean.FALSE, simpleSymbol2);
                simpleSymbol3 = Lit138;
                bool = Boolean.TRUE;
                runtime.setAndCoerceProperty$Ex(simpleSymbol3, simpleSymbol, bool, simpleSymbol2);
                simpleSymbol4 = Lit398;
                bool2 = Boolean.FALSE;
                return runtime.setAndCoerceProperty$Ex(simpleSymbol4, simpleSymbol, bool2, simpleSymbol2);
            } else if (runtime.getProperty$1(Lit216, Lit413) != Boolean.FALSE) {
                SimpleSymbol simpleSymbol8 = Lit139;
                simpleSymbol = Lit136;
                Boolean bool6 = Boolean.FALSE;
                simpleSymbol2 = Lit137;
                runtime.setAndCoerceProperty$Ex(simpleSymbol8, simpleSymbol, bool6, simpleSymbol2);
                simpleSymbol5 = Lit135;
                bool3 = Boolean.TRUE;
            } else {
                SimpleSymbol simpleSymbol9 = Lit139;
                simpleSymbol = Lit136;
                Boolean bool7 = Boolean.FALSE;
                simpleSymbol2 = Lit137;
                runtime.setAndCoerceProperty$Ex(simpleSymbol9, simpleSymbol, bool7, simpleSymbol2);
                runtime.setAndCoerceProperty$Ex(Lit138, simpleSymbol, Boolean.FALSE, simpleSymbol2);
                runtime.setAndCoerceProperty$Ex(Lit135, simpleSymbol, Boolean.FALSE, simpleSymbol2);
                simpleSymbol4 = Lit398;
                bool2 = Boolean.TRUE;
                return runtime.setAndCoerceProperty$Ex(simpleSymbol4, simpleSymbol, bool2, simpleSymbol2);
            }
        }
        runtime.setAndCoerceProperty$Ex(simpleSymbol5, simpleSymbol, bool3, simpleSymbol2);
        simpleSymbol3 = Lit138;
        bool = Boolean.FALSE;
        runtime.setAndCoerceProperty$Ex(simpleSymbol3, simpleSymbol, bool, simpleSymbol2);
        simpleSymbol4 = Lit398;
        bool2 = Boolean.FALSE;
        return runtime.setAndCoerceProperty$Ex(simpleSymbol4, simpleSymbol, bool2, simpleSymbol2);
    }

    static Object lambda127() {
        return runtime.setAndCoerceProperty$Ex(Lit420, Lit421, Lit422, Lit109);
    }

    static Object lambda128() {
        return runtime.setAndCoerceProperty$Ex(Lit420, Lit421, Lit422, Lit109);
    }

    static Object lambda129() {
        return runtime.setAndCoerceProperty$Ex(Lit425, Lit426, Lit427, Lit109);
    }

    static Object lambda130() {
        return runtime.setAndCoerceProperty$Ex(Lit425, Lit426, Lit427, Lit109);
    }

    public Object Clock1$Timer() {
        SimpleSymbol simpleSymbol;
        Boolean bool;
        SimpleSymbol simpleSymbol2;
        Boolean bool2;
        SimpleSymbol simpleSymbol3;
        String str;
        runtime.setThisForm();
        SimpleSymbol simpleSymbol4 = Lit216;
        if (runtime.getProperty$1(simpleSymbol4, Lit429) != Boolean.FALSE) {
            SimpleSymbol simpleSymbol5 = Lit145;
            SimpleSymbol simpleSymbol6 = Lit136;
            Boolean bool3 = Boolean.TRUE;
            SimpleSymbol simpleSymbol7 = Lit137;
            runtime.setAndCoerceProperty$Ex(simpleSymbol5, simpleSymbol6, bool3, simpleSymbol7);
            SimpleSymbol simpleSymbol8 = Lit186;
            SimpleSymbol simpleSymbol9 = Lit194;
            SimpleSymbol simpleSymbol10 = Lit111;
            runtime.setAndCoerceProperty$Ex(simpleSymbol8, simpleSymbol9, "Available Devices", simpleSymbol10);
            if (runtime.getProperty$1(simpleSymbol4, Lit413) != Boolean.FALSE) {
                runtime.setAndCoerceProperty$Ex(Lit173, Lit175, "bluetoothConnected.png", simpleSymbol10);
                NumberCompare numberCompare = Scheme.numGrt;
                SimpleSymbol simpleSymbol11 = Lit430;
                if (runtime.callYailPrimitive(numberCompare, LList.list2(runtime.callComponentMethod(simpleSymbol4, simpleSymbol11, LList.Empty, LList.Empty), Lit45), Lit431, ">") != Boolean.FALSE) {
                    SimpleSymbol simpleSymbol12 = Lit7;
                    runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol12, runtime.callComponentMethod(simpleSymbol4, Lit432, LList.list1(runtime.callComponentMethod(simpleSymbol4, simpleSymbol11, LList.Empty, LList.Empty)), Lit433));
                    SimpleSymbol simpleSymbol13 = Lit5;
                    runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol13, runtime.callYailPrimitive(runtime.string$Mnsplit, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol12, runtime.$Stthe$Mnnull$Mnvalue$St), "|"), Lit434, "split"));
                    ModuleMethod moduleMethod = runtime.yail$Mnequal$Qu;
                    Object callYailPrimitive = runtime.callYailPrimitive(runtime.yail$Mnlist$Mnlength, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol13, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit435, "length of list");
                    IntNum intNum = Lit115;
                    if (runtime.callYailPrimitive(moduleMethod, LList.list2(callYailPrimitive, intNum), Lit436, "=") != Boolean.FALSE) {
                        SimpleSymbol simpleSymbol14 = Lit9;
                        ModuleMethod moduleMethod2 = runtime.yail$Mnlist$Mnget$Mnitem;
                        Object lookupGlobalVarInCurrentFormEnvironment = runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol13, runtime.$Stthe$Mnnull$Mnvalue$St);
                        IntNum intNum2 = Lit157;
                        runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol14, runtime.callYailPrimitive(moduleMethod2, LList.list2(lookupGlobalVarInCurrentFormEnvironment, intNum2), Lit437, "select list item"));
                        SimpleSymbol simpleSymbol15 = Lit11;
                        runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol15, runtime.callYailPrimitive(runtime.yail$Mnlist$Mnget$Mnitem, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol13, runtime.$Stthe$Mnnull$Mnvalue$St), intNum), Lit438, "select list item"));
                        SimpleSymbol simpleSymbol16 = Lit12;
                        SimpleSymbol simpleSymbol17 = simpleSymbol12;
                        runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol16, runtime.callYailPrimitive(runtime.string$Mnsplit, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol15, runtime.$Stthe$Mnnull$Mnvalue$St), ","), Lit439, "split"));
                        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callYailPrimitive(runtime.yail$Mnlist$Mnlength, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol16, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit440, "length of list"), Lit441), Lit442, "=") != Boolean.FALSE) {
                            runtime.addGlobalVarToCurrentFormEnvironment(Lit10, runtime.callYailPrimitive(runtime.yail$Mnlist$Mnget$Mnitem, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol16, runtime.$Stthe$Mnnull$Mnvalue$St), Lit443), Lit444, "select list item"));
                            runtime.addGlobalVarToCurrentFormEnvironment(Lit8, runtime.callYailPrimitive(runtime.yail$Mnlist$Mnget$Mnitem, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol16, runtime.$Stthe$Mnnull$Mnvalue$St), intNum2), Lit445, "select list item"));
                            runtime.addGlobalVarToCurrentFormEnvironment(Lit6, runtime.callYailPrimitive(runtime.yail$Mnlist$Mnget$Mnitem, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol16, runtime.$Stthe$Mnnull$Mnvalue$St), intNum), Lit446, "select list item"));
                            runtime.setAndCoerceProperty$Ex(Lit322, Lit315, runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol15, runtime.$Stthe$Mnnull$Mnvalue$St), simpleSymbol10);
                        }
                        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callYailPrimitive(runtime.string$Mnempty$Qu, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol14, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit447, "is text empty?"), Boolean.FALSE), Lit448, "=") != Boolean.FALSE) {
                            if (runtime.processAndDelayed$V(new Object[]{lambda$Fn130, lambda$Fn131}) != Boolean.FALSE) {
                                if (runtime.processAndDelayed$V(new Object[]{lambda$Fn132, lambda$Fn133}) != Boolean.FALSE) {
                                    SimpleSymbol simpleSymbol18 = Lit235;
                                    SimpleSymbol simpleSymbol19 = Lit118;
                                    Object lookupGlobalVarInCurrentFormEnvironment2 = runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St);
                                    SimpleSymbol simpleSymbol20 = Lit109;
                                    runtime.setAndCoerceProperty$Ex(simpleSymbol18, simpleSymbol19, lookupGlobalVarInCurrentFormEnvironment2, simpleSymbol20);
                                    runtime.setAndCoerceProperty$Ex(Lit230, simpleSymbol19, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit21, runtime.$Stthe$Mnnull$Mnvalue$St), simpleSymbol20);
                                    simpleSymbol3 = Lit262;
                                    str = "Good";
                                } else {
                                    if (runtime.processAndDelayed$V(new Object[]{lambda$Fn134, lambda$Fn135}) != Boolean.FALSE) {
                                        SimpleSymbol simpleSymbol21 = Lit235;
                                        SimpleSymbol simpleSymbol22 = Lit118;
                                        Object lookupGlobalVarInCurrentFormEnvironment3 = runtime.lookupGlobalVarInCurrentFormEnvironment(Lit29, runtime.$Stthe$Mnnull$Mnvalue$St);
                                        SimpleSymbol simpleSymbol23 = Lit109;
                                        runtime.setAndCoerceProperty$Ex(simpleSymbol21, simpleSymbol22, lookupGlobalVarInCurrentFormEnvironment3, simpleSymbol23);
                                        runtime.setAndCoerceProperty$Ex(Lit230, simpleSymbol22, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit37, runtime.$Stthe$Mnnull$Mnvalue$St), simpleSymbol23);
                                        simpleSymbol3 = Lit262;
                                        str = "Moderate";
                                    }
                                }
                                runtime.setAndCoerceProperty$Ex(simpleSymbol3, simpleSymbol9, str, simpleSymbol10);
                                runtime.setAndCoerceProperty$Ex(Lit258, simpleSymbol6, Boolean.FALSE, simpleSymbol7);
                                runtime.setAndCoerceProperty$Ex(Lit267, simpleSymbol6, Boolean.FALSE, simpleSymbol7);
                            } else {
                                if (runtime.processAndDelayed$V(new Object[]{lambda$Fn136, lambda$Fn137}) != Boolean.FALSE) {
                                    if (runtime.processAndDelayed$V(new Object[]{lambda$Fn138, lambda$Fn139}) != Boolean.FALSE) {
                                        SimpleSymbol simpleSymbol24 = Lit235;
                                        SimpleSymbol simpleSymbol25 = Lit118;
                                        Object lookupGlobalVarInCurrentFormEnvironment4 = runtime.lookupGlobalVarInCurrentFormEnvironment(Lit50, runtime.$Stthe$Mnnull$Mnvalue$St);
                                        SimpleSymbol simpleSymbol26 = Lit109;
                                        runtime.setAndCoerceProperty$Ex(simpleSymbol24, simpleSymbol25, lookupGlobalVarInCurrentFormEnvironment4, simpleSymbol26);
                                        runtime.setAndCoerceProperty$Ex(Lit230, simpleSymbol25, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit57, runtime.$Stthe$Mnnull$Mnvalue$St), simpleSymbol26);
                                        runtime.setAndCoerceProperty$Ex(Lit262, simpleSymbol9, "Unhealthy", simpleSymbol10);
                                        runtime.setAndCoerceProperty$Ex(Lit258, simpleSymbol6, Boolean.FALSE, simpleSymbol7);
                                        simpleSymbol2 = Lit267;
                                        bool2 = Boolean.TRUE;
                                    } else {
                                        if (runtime.processAndDelayed$V(new Object[]{lambda$Fn140, lambda$Fn141}) != Boolean.FALSE) {
                                            SimpleSymbol simpleSymbol27 = Lit235;
                                            SimpleSymbol simpleSymbol28 = Lit118;
                                            Object lookupGlobalVarInCurrentFormEnvironment5 = runtime.lookupGlobalVarInCurrentFormEnvironment(Lit63, runtime.$Stthe$Mnnull$Mnvalue$St);
                                            SimpleSymbol simpleSymbol29 = Lit109;
                                            runtime.setAndCoerceProperty$Ex(simpleSymbol27, simpleSymbol28, lookupGlobalVarInCurrentFormEnvironment5, simpleSymbol29);
                                            runtime.setAndCoerceProperty$Ex(Lit230, simpleSymbol28, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit70, runtime.$Stthe$Mnnull$Mnvalue$St), simpleSymbol29);
                                            runtime.setAndCoerceProperty$Ex(Lit262, simpleSymbol9, "Unhealthy", simpleSymbol10);
                                        } else {
                                            if (runtime.processAndDelayed$V(new Object[]{lambda$Fn142, lambda$Fn143}) != Boolean.FALSE) {
                                                SimpleSymbol simpleSymbol30 = Lit235;
                                                SimpleSymbol simpleSymbol31 = Lit118;
                                                Object lookupGlobalVarInCurrentFormEnvironment6 = runtime.lookupGlobalVarInCurrentFormEnvironment(Lit78, runtime.$Stthe$Mnnull$Mnvalue$St);
                                                SimpleSymbol simpleSymbol32 = Lit109;
                                                runtime.setAndCoerceProperty$Ex(simpleSymbol30, simpleSymbol31, lookupGlobalVarInCurrentFormEnvironment6, simpleSymbol32);
                                                runtime.setAndCoerceProperty$Ex(Lit230, simpleSymbol31, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit84, runtime.$Stthe$Mnnull$Mnvalue$St), simpleSymbol32);
                                                runtime.setAndCoerceProperty$Ex(Lit262, simpleSymbol9, "Unhealthy", simpleSymbol10);
                                                simpleSymbol = Lit258;
                                                bool = Boolean.TRUE;
                                                runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, bool, simpleSymbol7);
                                                simpleSymbol2 = Lit267;
                                                bool2 = Boolean.FALSE;
                                            } else {
                                                if (runtime.processAndDelayed$V(new Object[]{lambda$Fn144, lambda$Fn145}) != Boolean.FALSE) {
                                                    SimpleSymbol simpleSymbol33 = Lit235;
                                                    SimpleSymbol simpleSymbol34 = Lit118;
                                                    Object lookupGlobalVarInCurrentFormEnvironment7 = runtime.lookupGlobalVarInCurrentFormEnvironment(Lit91, runtime.$Stthe$Mnnull$Mnvalue$St);
                                                    SimpleSymbol simpleSymbol35 = Lit109;
                                                    runtime.setAndCoerceProperty$Ex(simpleSymbol33, simpleSymbol34, lookupGlobalVarInCurrentFormEnvironment7, simpleSymbol35);
                                                    runtime.setAndCoerceProperty$Ex(Lit230, simpleSymbol34, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit99, runtime.$Stthe$Mnnull$Mnvalue$St), simpleSymbol35);
                                                    runtime.setAndCoerceProperty$Ex(Lit262, simpleSymbol9, "Hazardous", simpleSymbol10);
                                                }
                                            }
                                        }
                                        simpleSymbol = Lit258;
                                        bool = Boolean.FALSE;
                                        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, bool, simpleSymbol7);
                                        simpleSymbol2 = Lit267;
                                        bool2 = Boolean.FALSE;
                                    }
                                    runtime.setAndCoerceProperty$Ex(simpleSymbol2, simpleSymbol6, bool2, simpleSymbol7);
                                }
                            }
                            runtime.setAndCoerceProperty$Ex(Lit245, simpleSymbol9, runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol14, runtime.$Stthe$Mnnull$Mnvalue$St), simpleSymbol10);
                            runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol17, "");
                            return runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol15, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list"));
                        }
                    }
                }
                return Values.empty;
            }
            runtime.setAndCoerceProperty$Ex(Lit173, Lit175, "bluetoothConnecting.png", simpleSymbol10);
            SimpleSymbol simpleSymbol36 = Lit3;
            runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol36, runtime.getProperty$1(simpleSymbol4, Lit467));
            return runtime.setAndCoerceProperty$Ex(simpleSymbol5, Lit148, runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol36, runtime.$Stthe$Mnnull$Mnvalue$St), Lit150);
        }
        SimpleSymbol simpleSymbol37 = Lit173;
        SimpleSymbol simpleSymbol38 = Lit175;
        SimpleSymbol simpleSymbol39 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol37, simpleSymbol38, "bluetoothDisabled.png", simpleSymbol39);
        runtime.setAndCoerceProperty$Ex(Lit145, Lit136, Boolean.FALSE, Lit137);
        return runtime.setAndCoerceProperty$Ex(Lit186, Lit194, "Enable Bluetooth", simpleSymbol39);
    }

    static Object lambda131() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit45), Lit449, ">=");
    }

    static Object lambda132() {
        return runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit422), Lit450, "<");
    }

    static Object lambda133() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit45), Lit451, ">=");
    }

    static Object lambda134() {
        return runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit183), Lit452, "<");
    }

    static Object lambda135() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit183), Lit453, ">=");
    }

    static Object lambda136() {
        return runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit422), Lit454, "<");
    }

    static Object lambda137() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit422), Lit455, ">=");
    }

    static Object lambda138() {
        return runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit427), Lit456, "<");
    }

    static Object lambda139() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit422), Lit457, ">=");
    }

    static Object lambda140() {
        return runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit232), Lit458, "<");
    }

    static Object lambda141() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit232), Lit459, ">=");
    }

    static Object lambda142() {
        return runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit460), Lit461, "<");
    }

    static Object lambda143() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit460), Lit462, ">=");
    }

    static Object lambda144() {
        return runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit463), Lit464, "<");
    }

    static Object lambda145() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit463), Lit465, ">=");
    }

    static Object lambda146() {
        return runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit427), Lit466, "<");
    }

    static Object lambda147() {
        SimpleSymbol simpleSymbol = Lit471;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit472;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit473, Boolean.TRUE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit474, Lit45, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit475, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit476;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansRegular.ttf", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit477, Lit478, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit479, "CanvaSansBold.ttf", simpleSymbol5);
    }

    static Object lambda148() {
        SimpleSymbol simpleSymbol = Lit471;
        SimpleSymbol simpleSymbol2 = Lit118;
        IntNum intNum = Lit472;
        SimpleSymbol simpleSymbol3 = Lit109;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit473, Boolean.TRUE, Lit137);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit474, Lit45, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit196, Lit475, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit476;
        SimpleSymbol simpleSymbol5 = Lit111;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "CanvaSansRegular.ttf", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit477, Lit478, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit479, "CanvaSansBold.ttf", simpleSymbol5);
    }

    static Object lambda149() {
        return runtime.setAndCoerceProperty$Ex(Lit482, Lit426, Lit483, Lit109);
    }

    static Object lambda150() {
        return runtime.setAndCoerceProperty$Ex(Lit482, Lit426, Lit483, Lit109);
    }

    public Object VibrationClock$Timer() {
        runtime.setThisForm();
        if (runtime.getProperty$1(Lit216, Lit413) != Boolean.FALSE) {
            if (runtime.processAndDelayed$V(new Object[]{lambda$Fn150, lambda$Fn151, lambda$Fn152}) != Boolean.FALSE) {
                if (runtime.processOrDelayed$V(new Object[]{lambda$Fn153, lambda$Fn156, lambda$Fn157, lambda$Fn158}) != Boolean.FALSE) {
                    return runtime.callComponentMethod(Lit420, Lit497, LList.list1(Lit427), Lit498);
                }
            }
        }
        return Values.empty;
    }

    static Object lambda151() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callYailPrimitive(runtime.yail$Mnlist$Mnlength, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit485, "length of list"), Lit115), Lit486, "=");
    }

    static Object lambda152() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callYailPrimitive(runtime.yail$Mnlist$Mnlength, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit12, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit487, "length of list"), Lit441), Lit488, "=");
    }

    static Object lambda153() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callYailPrimitive(runtime.string$Mnempty$Qu, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit489, "is text empty?"), Boolean.FALSE), Lit490, "=");
    }

    static Object lambda154() {
        return runtime.processAndDelayed$V(new Object[]{lambda$Fn154, lambda$Fn155});
    }

    static Object lambda155() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit422), Lit491, ">=");
    }

    static Object lambda156() {
        return runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit427), Lit492, "<");
    }

    static Object lambda157() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit10, runtime.$Stthe$Mnnull$Mnvalue$St), Lit359), Lit493, ">=");
    }

    static Object lambda158() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit8, runtime.$Stthe$Mnnull$Mnvalue$St), Lit494), Lit495, ">=");
    }

    static Object lambda159() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit6, runtime.$Stthe$Mnnull$Mnvalue$St), Lit232), Lit496, ">=");
    }

    static Object lambda160() {
        return runtime.setAndCoerceProperty$Ex(Lit501, Lit426, Lit502, Lit109);
    }

    static Object lambda161() {
        return runtime.setAndCoerceProperty$Ex(Lit501, Lit426, Lit502, Lit109);
    }

    public Object NotifierClock$Timer() {
        runtime.setThisForm();
        if (runtime.getProperty$1(Lit216, Lit413) != Boolean.FALSE) {
            if (runtime.processAndDelayed$V(new Object[]{lambda$Fn161, lambda$Fn162, lambda$Fn163}) != Boolean.FALSE) {
                if (runtime.processOrDelayed$V(new Object[]{lambda$Fn164, lambda$Fn167, lambda$Fn168, lambda$Fn169}) != Boolean.FALSE) {
                    SimpleSymbol simpleSymbol = Lit471;
                    SimpleSymbol simpleSymbol2 = Lit515;
                    Pair list1 = LList.list1("The surrounding area is unsafe!");
                    LList.chain1(LList.chain4(list1, "AsthmAlert", Boolean.TRUE, Boolean.TRUE, Lit422), "");
                    return runtime.callComponentMethod(simpleSymbol, simpleSymbol2, list1, Lit516);
                }
            }
        }
        return Values.empty;
    }

    static Object lambda162() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callYailPrimitive(runtime.yail$Mnlist$Mnlength, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit504, "length of list"), Lit115), Lit505, "=");
    }

    static Object lambda163() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callYailPrimitive(runtime.yail$Mnlist$Mnlength, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit12, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit506, "length of list"), Lit441), Lit507, "=");
    }

    static Object lambda164() {
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callYailPrimitive(runtime.string$Mnempty$Qu, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit508, "is text empty?"), Boolean.FALSE), Lit509, "=");
    }

    static Object lambda165() {
        return runtime.processAndDelayed$V(new Object[]{lambda$Fn165, lambda$Fn166});
    }

    static Object lambda166() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit422), Lit510, ">=");
    }

    static Object lambda167() {
        return runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit9, runtime.$Stthe$Mnnull$Mnvalue$St), Lit427), Lit511, "<");
    }

    static Object lambda168() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit10, runtime.$Stthe$Mnnull$Mnvalue$St), Lit359), Lit512, ">=");
    }

    static Object lambda169() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit8, runtime.$Stthe$Mnnull$Mnvalue$St), Lit494), Lit513, ">=");
    }

    static Object lambda170() {
        return runtime.callYailPrimitive(Scheme.numGEq, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit6, runtime.$Stthe$Mnnull$Mnvalue$St), Lit232), Lit514, ">=");
    }

    public String getSimpleName(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public void addToFormEnvironment(Symbol symbol, Object obj) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", symbol, this.form$Mnenvironment, obj));
        this.form$Mnenvironment.put(symbol, obj);
    }

    public Object lookupInFormEnvironment(Symbol symbol, Object obj) {
        Environment environment = this.form$Mnenvironment;
        int i = 1 & ((environment == null ? 1 : 0) + 1);
        if (i != 0) {
            if (!environment.isBound(symbol)) {
                return obj;
            }
        } else if (i == 0) {
            return obj;
        }
        return this.form$Mnenvironment.get(symbol);
    }

    public boolean isBoundInFormEnvironment(Symbol symbol) {
        return this.form$Mnenvironment.isBound(symbol);
    }

    public void addToGlobalVarEnvironment(Symbol symbol, Object obj) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", symbol, this.global$Mnvar$Mnenvironment, obj));
        this.global$Mnvar$Mnenvironment.put(symbol, obj);
    }

    public void addToEvents(Object obj, Object obj2) {
        this.events$Mnto$Mnregister = lists.cons(lists.cons(obj, obj2), this.events$Mnto$Mnregister);
    }

    public void addToComponents(Object obj, Object obj2, Object obj3, Object obj4) {
        this.components$Mnto$Mncreate = lists.cons(LList.list4(obj, obj2, obj3, obj4), this.components$Mnto$Mncreate);
    }

    public void addToGlobalVars(Object obj, Object obj2) {
        this.global$Mnvars$Mnto$Mncreate = lists.cons(LList.list2(obj, obj2), this.global$Mnvars$Mnto$Mncreate);
    }

    public void addToFormDoAfterCreation(Object obj) {
        this.form$Mndo$Mnafter$Mncreation = lists.cons(obj, this.form$Mndo$Mnafter$Mncreation);
    }

    public void sendError(Object obj) {
        RetValManager.sendError(obj == null ? null : obj.toString());
    }

    public void processException(Object obj) {
        Object apply1 = Scheme.applyToArgs.apply1(GetNamedPart.getNamedPart.apply2(obj, Lit1));
        RuntimeErrorAlert.alert(this, apply1 == null ? null : apply1.toString(), obj instanceof YailRuntimeError ? ((YailRuntimeError) obj).getErrorType() : "Runtime Error", "End Application");
    }

    public boolean dispatchEvent(Component component, String str, String str2, Object[] objArr) {
        SimpleSymbol string$To$Symbol = misc.string$To$Symbol(str);
        if (!isBoundInFormEnvironment(string$To$Symbol)) {
            EventDispatcher.unregisterEventForDelegation(this, str, str2);
            return false;
        } else if (lookupInFormEnvironment(string$To$Symbol) != component) {
            return false;
        } else {
            boolean z = true;
            try {
                Scheme.apply.apply2(lookupHandler(str, str2), LList.makeList(objArr, 0));
                return true;
            } catch (StopBlocksExecution unused) {
                return false;
            } catch (PermissionException e) {
                e.printStackTrace();
                if (this != component) {
                    z = false;
                }
                if (!z ? !z : !IsEqual.apply(str2, "PermissionNeeded")) {
                    PermissionDenied(component, str2, e.getPermissionNeeded());
                    return false;
                }
                processException(e);
                return false;
            } catch (Throwable th) {
                androidLogForm(th.getMessage());
                th.printStackTrace();
                processException(th);
                return false;
            }
        }
    }

    public void dispatchGenericEvent(Component component, String str, boolean z, Object[] objArr) {
        boolean z2 = false;
        Object lookupInFormEnvironment = lookupInFormEnvironment(misc.string$To$Symbol(strings.stringAppend("any$", getSimpleName(component), "$", str)));
        if (lookupInFormEnvironment != Boolean.FALSE) {
            try {
                Scheme.apply.apply2(lookupInFormEnvironment, lists.cons(component, lists.cons(z ? Boolean.TRUE : Boolean.FALSE, LList.makeList(objArr, 0))));
            } catch (StopBlocksExecution unused) {
            } catch (PermissionException e) {
                e.printStackTrace();
                if (this == component) {
                    z2 = true;
                }
                if (!z2 ? !z2 : !IsEqual.apply(str, "PermissionNeeded")) {
                    PermissionDenied(component, str, e.getPermissionNeeded());
                } else {
                    processException(e);
                }
            } catch (Throwable th) {
                androidLogForm(th.getMessage());
                th.printStackTrace();
                processException(th);
            }
        }
    }

    public Object lookupHandler(Object obj, Object obj2) {
        String str = null;
        String obj3 = obj == null ? null : obj.toString();
        if (obj2 != null) {
            str = obj2.toString();
        }
        return lookupInFormEnvironment(misc.string$To$Symbol(EventDispatcher.makeFullEventName(obj3, str)));
    }

    public static SimpleSymbol lambda1symbolAppend$V(Object[] objArr) {
        Object makeList = LList.makeList(objArr, 0);
        Apply apply = Scheme.apply;
        ModuleMethod moduleMethod = strings.string$Mnappend;
        Object obj = LList.Empty;
        while (makeList != LList.Empty) {
            try {
                Pair pair = (Pair) makeList;
                Object cdr = pair.getCdr();
                Object car = pair.getCar();
                try {
                    obj = Pair.make(misc.symbol$To$String((Symbol) car), obj);
                    makeList = cdr;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "symbol->string", 1, car);
                }
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "arg0", -2, makeList);
            }
        }
        Object apply2 = apply.apply2(moduleMethod, LList.reverseInPlace(obj));
        try {
            return misc.string$To$Symbol((CharSequence) apply2);
        } catch (ClassCastException e3) {
            throw new WrongType(e3, "string->symbol", 1, apply2);
        }
    }

    public void $define() {
        Object reverse;
        Object obj;
        Object reverse2;
        Object reverse3;
        Object obj2;
        Object apply1;
        Object apply12;
        Object apply13;
        Language.setDefaults(Scheme.getInstance());
        try {
            run();
        } catch (Exception e) {
            androidLogForm(e.getMessage());
            processException(e);
        }
        Screen1 = this;
        addToFormEnvironment(Lit0, this);
        Object obj3 = this.events$Mnto$Mnregister;
        while (obj3 != LList.Empty) {
            try {
                Pair pair = (Pair) obj3;
                Object car = pair.getCar();
                Object apply14 = lists.car.apply1(car);
                String str = null;
                String obj4 = apply14 == null ? null : apply14.toString();
                Object apply15 = lists.cdr.apply1(car);
                if (apply15 != null) {
                    str = apply15.toString();
                }
                EventDispatcher.registerEventForDelegation(this, obj4, str);
                obj3 = pair.getCdr();
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "arg0", -2, obj3);
            }
        }
        try {
            reverse = lists.reverse(this.components$Mnto$Mncreate);
            addToGlobalVars(Lit2, lambda$Fn1);
            obj = reverse;
            while (obj != LList.Empty) {
                Pair pair2 = (Pair) obj;
                Object car2 = pair2.getCar();
                apply12 = lists.caddr.apply1(car2);
                lists.cadddr.apply1(car2);
                Object apply16 = lists.cadr.apply1(car2);
                apply13 = lists.car.apply1(car2);
                Object apply2 = Invoke.make.apply2(apply16, lookupInFormEnvironment((Symbol) apply13));
                SlotSet.set$Mnfield$Ex.apply3(this, apply12, apply2);
                addToFormEnvironment((Symbol) apply12, apply2);
                obj = pair2.getCdr();
            }
            reverse2 = lists.reverse(this.global$Mnvars$Mnto$Mncreate);
            while (reverse2 != LList.Empty) {
                Pair pair3 = (Pair) reverse2;
                Object car3 = pair3.getCar();
                apply1 = lists.car.apply1(car3);
                addToGlobalVarEnvironment((Symbol) apply1, Scheme.applyToArgs.apply1(lists.cadr.apply1(car3)));
                reverse2 = pair3.getCdr();
            }
            reverse3 = lists.reverse(this.form$Mndo$Mnafter$Mncreation);
            while (reverse3 != LList.Empty) {
                Pair pair4 = (Pair) reverse3;
                misc.force(pair4.getCar());
                reverse3 = pair4.getCdr();
            }
            obj2 = reverse;
            while (obj2 != LList.Empty) {
                Pair pair5 = (Pair) obj2;
                Object car4 = pair5.getCar();
                lists.caddr.apply1(car4);
                Object apply17 = lists.cadddr.apply1(car4);
                if (apply17 != Boolean.FALSE) {
                    Scheme.applyToArgs.apply1(apply17);
                }
                obj2 = pair5.getCdr();
            }
            while (reverse != LList.Empty) {
                Pair pair6 = (Pair) reverse;
                Object car5 = pair6.getCar();
                Object apply18 = lists.caddr.apply1(car5);
                lists.cadddr.apply1(car5);
                callInitialize(SlotGet.field.apply2(this, apply18));
                reverse = pair6.getCdr();
            }
        } catch (ClassCastException e3) {
            throw new WrongType(e3, "arg0", -2, obj);
        } catch (ClassCastException e4) {
            throw new WrongType(e4, "lookup-in-form-environment", 0, apply13);
        } catch (ClassCastException e5) {
            throw new WrongType(e5, "add-to-form-environment", 0, apply12);
        } catch (ClassCastException e6) {
            throw new WrongType(e6, "arg0", -2, reverse2);
        } catch (ClassCastException e7) {
            throw new WrongType(e7, "add-to-global-var-environment", 0, apply1);
        } catch (ClassCastException e8) {
            throw new WrongType(e8, "arg0", -2, reverse3);
        } catch (ClassCastException e9) {
            throw new WrongType(e9, "arg0", -2, obj2);
        } catch (ClassCastException e10) {
            throw new WrongType(e10, "arg0", -2, reverse);
        } catch (YailRuntimeError e11) {
            processException(e11);
        }
    }
}
