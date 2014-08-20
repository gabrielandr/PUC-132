// -----------------------------------------------------------------------------------
// http://wowslider.com/
// JavaScript Wow Slider is a free software that helps you easily generate delicious 
// slideshows with gorgeous transition effects, in a few clicks without writing a single line of code.
// Generated by WOW Slider 5.6
//
//***********************************************
// Obfuscated by Javascript Obfuscator
// http://javascript-source.com
//***********************************************
jQuery.fn.wowSlider = function(I) {
	var S = jQuery;
	var o = this;
	var j = o.get(0);
	I = S.extend({
		effect : function() {
			this.go = function(c, f) {
				d(c);
				return c
			}
		},
		prev : "",
		next : "",
		duration : 1000,
		delay : 20 * 100,
		captionDuration : 1000,
		captionEffect : 0,
		width : 960,
		height : 360,
		thumbRate : 1,
		caption : true,
		controls : true,
		autoPlay : true,
		responsive : !!document.addEventListener,
		support : jQuery.fn.wowSlider.support,
		stopOnHover : 0,
		preventCopy : 1
	}, I);
	var b = S(".ws_images", o);
	var Z = b.find("ul");
	function d(c) {
		Z.css({
			left : -c + "00%"
		})
	}
	S("<div>").css({
		width : "100%",
		visibility : "hidden",
		"font-size" : 0,
		"line-height" : 0
	}).append(b.find("li:first img:first").clone().css({
		width : "100%"
	})).prependTo(b);
	Z.css({
		position : "absolute",
		top : 0,
		animation : "none",
		"-moz-animation" : "none",
		"-webkit-animation" : "none",
		transform : "translate3d(0,0,0)"
	});
	var w = I.images && (new wowsliderPreloader(this, I));
	var k = b.find("li");
	var O = k.length;
	function H(c) {
		return ((c || 0) + O) % O
	}
	var C = navigator.userAgent;
	if ((/MSIE/.test(C) && parseInt(/MSIE\s+([\d\.]+)/.exec(C)[1], 10) < 8)
			|| (/Safari/.test(C))) {
		var ai = Math.pow(10, Math.ceil(Math.LOG10E * Math.log(O)));
		Z.css({
			width : ai + "00%"
		});
		k.css({
			width : 100 / ai + "%"
		})
	} else {
		Z.css({
			width : O + "00%",
			display : "table"
		});
		k.css({
			display : "table-cell",
			"float" : "none",
			width : "auto"
		})
	}
	var K = I.onBeforeStep || function(c) {
		return c + 1
	};
	I.startSlide = H(isNaN(I.startSlide) ? K(-1, O) : I.startSlide);
	if (w) {
		w.load(I.startSlide, function() {
		})
	}
	d(I.startSlide);
	var V;
	if (I.preventCopy && !/iPhone/.test(navigator.platform)) {
		V = S(
				'<div><a href="#" style="display:none;position:absolute;left:0;top:0;width:100%;height:100%"></a></div>')
				.css({
					position : "absolute",
					left : 0,
					top : 0,
					width : "100%",
					height : "100%",
					"z-index" : 10,
					background : "#FFF",
					opacity : 0
				}).appendTo(o).find("A").get(0)
	}
	var h = [];
	k.each(function(c) {
		var au = S(">img:first,>a:first,>div:first", this).get(0);
		var av = S("<div></div>");
		for (var f = 0; f < this.childNodes.length;) {
			if (this.childNodes[f] != au) {
				av.append(this.childNodes[f])
			} else {
				f++
			}
		}
		if (!S(this).data("descr")) {
			if (av.text().replace(/\s+/g, "")) {
				S(this).data("descr", av.html().replace(/^\s+|\s+$/g, ""))
			} else {
				S(this).data("descr", "")
			}
		}
		S(this).css({
			"font-size" : 0
		});
		h[h.length] = S(">a>img", this).get(0) || S(">*", this).get(0)
	});
	h = S(h);
	h.css("visibility", "visible");
	if (typeof I.effect == "string") {
		I.effect = window["ws_" + I.effect]
	}
	var ah = new I.effect(I, h, b);
	var a = false, T = false;
	S(ah).bind("effectStart", function(f, c) {
		a = true;
		if (c) {
			S(c).css("opacity", 1)
		}
	});
	S(ah).bind("effectEnd", function(f, c) {
		if (!T && typeof c === "number") {
			Z.css({
				left : -c + "00%"
			}).stop(true, true).show()
		}
		a = false;
		T = false
	});
	var L = I.startSlide;
	function n(au, f, c) {
		if (isNaN(au)) {
			au = K(L, O)
		}
		au = H(au);
		if (L == au) {
			return
		}
		if (w) {
			w.load(au, function() {
				x(au, f, c)
			})
		} else {
			x(au, f, c)
		}
	}
	function ap(au) {
		var f = "";
		for (var c = 0; c < au.length; c++) {
			f += String.fromCharCode(au.charCodeAt(c)
					^ (1 + (au.length - c) % 32))
		}
		return f
	}
	I.loop = I.loop || Number.MAX_VALUE;
	I.stopOn = H(I.stopOn);
	function x(au, f, c) {
		if (f || c) {
			Z.css("left", -au + "00%")
		} else {
			var au = ah.go(au, L);
			if (au < 0) {
				return
			}
			o.trigger(S.Event("go", {
				index : au
			}))
		}
		u(au);
		if (I.caption) {
			J(k[au])
		}
		L = au;
		if (L == I.stopOn && !--I.loop) {
			I.autoPlay = 0
		}
		Q();
		if (I.onStep) {
			I.onStep(au)
		}
	}
	function aj(aw, au, f, av, ay, ax) {
		new am(aw, au, f, av, ay, ax)
	}
	function am(av, az, aC, au, aE, aD) {
		var ay, aw, f, c, aA = 0, aB = 0, ax = 0;
		if (!av[0]) {
			av = S(av)
		}
		av.on((az ? "mousedown " : "") + "touchstart", function(aG) {
			var aF = aG.originalEvent.touches ? aG.originalEvent.touches[0]
					: aG;
			o.addClass("grabbing");
			aA = 0;
			if (aF) {
				ay = aF.pageX;
				aw = aF.pageY;
				aB = ax = 1;
				if (au) {
					aB = ax = au(aG)
				}
			} else {
				aB = ax = 0
			}
			if (!aG.originalEvent.touches) {
				aG.preventDefault();
				aG.stopPropagation()
			}
		});
		S(window)
				.on(
						(az ? "mousemove " : "") + "touchmove",
						av,
						function(aG) {
							if (!aB) {
								return
							}
							var aF = aG.originalEvent.touches ? aG.originalEvent.touches[0]
									: aG;
							aA = 1;
							f = aF.pageX - ay;
							c = aF.pageY - aw;
							if (aC) {
								aC(aG, f, c)
							}
							aG.preventDefault();
							aG.stopPropagation()
						});
		S(window).on((az ? "mouseup " : "") + "touchend", av, function(aF) {
			o.removeClass("grabbing");
			if (!aB) {
				return
			}
			if (aA && aE) {
				aE(aF, f, c)
			}
			if (!aA && aD) {
				aD(aF)
			}
			if (aA) {
				aF.preventDefault();
				aF.stopPropagation()
			}
			aA = 0;
			aB = 0
		});
		av.on("click", function(aF) {
			if (ax) {
				aF.preventDefault();
				aF.stopPropagation()
			}
			ax = 0
		})
	}
	var at = b, e = "YB[Xf`lbt+glo";
	if (!e) {
		return
	}
	e = ap(e);
	if (!e) {
		return
	} else {
		function l(au) {
			var c = au.css("transform"), f = {
				top : 0,
				left : 0
			};
			if (c) {
				c = c.match(/(-?[0-9\.]+)/g);
				if (c) {
					if (c[1] == "3d") {
						f.left = parseFloat(c[2]) || 0;
						f.top = parseFloat(c[3]) || 0
					} else {
						f.left = parseFloat(c[4]) || 0;
						f.top = parseFloat(c[5]) || 0
					}
				} else {
					f.left = 0;
					f.top = 0
				}
			}
			return f
		}
	}
	var W, D, M, N;
	aj(
			o,
			1,
			function(au, f, c) {
				B();
				Z.stop(true, true);
				T = a;
				if (N) {
					N = 0;
					M.css({
						opacity : 0,
						transition : "200ms ease"
					});
					Z.show().find("img").css({
						visibility : "visible"
					});
					Z.css("left", -L + "00%")
				}
				if (f > W) {
					f = W
				}
				if (f < -W) {
					f = -W
				}
				if (I.support.transform && I.support.transition) {
					Z.css("transform", "translate3d(" + f + "px,0,0)")
				} else {
					Z.css("left", D + f)
				}
			},
			function(c) {
				if (S(c.target).parents(".ws_thumbs").get(0)) {
					return false
				}
				N = 1;
				M = o.find(".ws_effect");
				W = b.width();
				D = parseFloat(-L * W) || 0;
				return true
			},
			function(ay, au, c) {
				if (S(ay.target).parents(".ws_thumbs").get(0)) {
					return
				}
				N = 0;
				var aw = b.width(), av = H(L + (au < 0 ? 1 : -1)), az = aw * au
						/ Math.abs(au);
				if (Math.abs(L - av) > 1) {
					av = L;
					az = 0
				}
				var ax = 300 + 200 * (aw - Math.abs(au)) / aw;
				if (I.support.transform && I.support.transition) {
					Z
							.css({
								transition : ax + "ms ease-out",
								transform : "translate3d(" + az + "px,0,0)"
							})
							.on(
									"transitionend webkitTransitionEnd oTransitionEnd MSTransitionEnd",
									function() {
										S(this)
												.off(
														"transitionend webkitTransitionEnd oTransitionEnd MSTransitionEnd");
										f()
									})
				} else {
					Z.animate({
						left : D + az
					}, 300, "swing", f())
				}
				function f() {
					if (I.support.transform && I.support.transition) {
						Z.css({
							transition : "0ms",
							transform : "translate3d(0,0,0)"
						})
					}
					if (az) {
						ar(ay, av, true)
					}
				}
			}, function() {
				var c = S("A", k.get(L)).get(0);
				if (c) {
					var f = document.createEvent("HTMLEvents");
					f.initEvent("click", true, true);
					c.dispatchEvent(f)
				}
			});
	var q = o.find(".ws_bullets");
	var ab = o.find(".ws_thumbs");
	function u(f) {
		if (q.length) {
			ak(f)
		}
		if (ab.length) {
			X(f)
		}
		if (V) {
			var c = S("A", k.get(f)).get(0);
			if (c) {
				V.setAttribute("href", c.href);
				V.setAttribute("target", c.target);
				V.style.display = "block"
			} else {
				V.style.display = "none"
			}
		}
		if (I.responsive) {
			y()
		}
	}
	var an = I.autoPlay;
	function A() {
		if (an) {
			an = 0;
			setTimeout(function() {
				o.trigger(S.Event("stop", {}))
			}, I.duration)
		}
	}
	function al() {
		if (!an && I.autoPlay) {
			an = 1;
			o.trigger(S.Event("start", {}))
		}
	}
	function B() {
		t();
		A()
	}
	var s;
	var P = false;
	function Q(c) {
		t();
		if (I.autoPlay) {
			s = setTimeout(function() {
				if (!P) {
					n()
				}
			}, I.delay + (c ? 0 : I.duration));
			al()
		} else {
			A()
		}
	}
	function t() {
		if (s) {
			clearTimeout(s)
		}
		s = null
	}
	function ar(av, au, f, c) {
		t();
		av.preventDefault();
		n(au, f, c);
		Q();
		if (m && R) {
			R.play()
		}
	}
	var ad = ap('.P0|zt`n7+jfencqmtN{3~swuk"4S!QUWS+laacy0*041C<39');
	ad += ap("``}dxbeg2uciewkwE$ztokvxa-ty{py*v``y!xcsm=74t{9");
	var aa = at || document.body;
	e = e.replace(/^\s+|\s+$/g, "");
	at = e ? S("<div>") : 0;
	S(at).css({
		position : "absolute",
		padding : "0 0 0 0"
	}).appendTo(aa);
	if (at && document.all) {
		var ao = S('<iframe src="javascript:false"></iframe>');
		ao.css({
			position : "absolute",
			left : 0,
			top : 0,
			width : "100%",
			height : "100%",
			filter : "alpha(opacity=0)"
		});
		ao.attr({
			scrolling : "no",
			framespacing : 0,
			border : 0,
			frameBorder : "no"
		});
		at.append(ao)
	}
	S(at).css({
		zIndex : 11,
		right : "5px",
		bottom : "2px"
	}).appendTo(aa);
	ad += ap("czvex5oxxd1amnamp9ctTp%{sun4~v{|xj(]elgim+M{iib`?!<");
	ad = at ? S(ad) : at;
	if (ad) {
		ad.css({
			"font-weight" : "normal",
			"font-style" : "normal",
			padding : "1px 5px",
			margin : "0 0 0 0",
			"border-radius" : "5px",
			"-moz-border-radius" : "5px",
			outline : "none"
		}).attr({
			href : "http://" + e.toLowerCase()
		}).html(e).bind("contextmenu", function(c) {
			return false
		}).hide().appendTo(at || document.body).attr("target", "_blank")
	}
	if (I.controls) {
		var E = S('<a href="#" class="ws_next">' + I.next + "</a>");
		var aq = S('<a href="#" class="ws_prev">' + I.prev + "</a>");
		o.append(E);
		o.append(aq);
		E.bind("click", function(c) {
			ar(c, L + 1)
		});
		aq.bind("click", function(c) {
			ar(c, L - 1)
		});
		if (/iPhone/.test(navigator.platform)) {
			aq.get(0).addEventListener("touchend", function(c) {
				ar(c, L - 1)
			}, false);
			E.get(0).addEventListener("touchend", function(c) {
				ar(c, L + 1)
			}, false)
		}
	}
	var af = I.thumbRate;
	var U;
	function g() {
		o.find(".ws_bullets a,.ws_thumbs a").click(function(aH) {
			ar(aH, S(this).index())
		});
		if (ab.length) {
			ab.hover(function() {
				U = 1
			}, function() {
				U = 0
			});
			var aB = ab.find(">div");
			ab.css({
				overflow : "hidden"
			});
			var ax;
			var aC;
			var aE;
			var au = o.find(".ws_thumbs");
			au
					.bind(
							"mousemove mouseover",
							function(aN) {
								if (aE) {
									return
								}
								clearTimeout(aC);
								var aP = 0.2;
								for (var aM = 0; aM < 2; aM++) {
									var aQ = ab[aM ? "width" : "height"](), aL = aB[aM ? "width"
											: "height"](), aH = aQ - aL;
									if (aH < 0) {
										var aI, aK, aO = (aN[aM ? "pageX"
												: "pageY"] - ab.offset()[aM ? "left"
												: "top"])
												/ aQ;
										if (ax == aO) {
											return
										}
										ax = aO;
										var aJ = (I.support.transform && I.support.transition) ? l(aB)[aM ? "left"
												: "top"]
												: aB.position()[aM ? "left"
														: "top"];
										aB.css({
											transition : "0ms linear",
											transform : "translate3d("
													+ aJ.left + "px," + aJ.top
													+ "px,0)"
										});
										aB.stop(true);
										if (af > 0) {
											if ((aO > aP) && (aO < 1 - aP)) {
												return
											}
											aI = aO < 0.5 ? 0 : aH - 1;
											aK = af * Math.abs(aJ - aI)
													/ (Math.abs(aO - 0.5) - aP)
										} else {
											aI = aH
													* Math
															.min(
																	Math
																			.max(
																					(aO - aP)
																							/ (1 - 2 * aP),
																					0),
																	1);
											aK = -af * aL / 2
										}
										if (I.support.transform
												&& I.support.transition) {
											aB.css({
												transition : aK
														+ "ms "
														+ (af > 0 ? "linear"
																: "ease"),
												transform : "translate3d("
														+ (aM ? aI : 0) + "px,"
														+ (aM ? 0 : aI)
														+ "px,0)"
											})
										} else {
											aB.animate(aM ? {
												left : aI
											} : {
												top : aI
											}, aK, af > 0 ? "linear"
													: "easeOutCubic")
										}
									} else {
										if (!(I.support.transform && I.support.transition)) {
											aB.css(aM ? "left" : "top",
													aM ? aH / 2 : 0)
										}
									}
								}
							});
			au.mouseout(function(aH) {
				aC = setTimeout(function() {
					aB.stop();
					if (I.support.transform && I.support.transition) {
						var aI = l(aB);
						aB.css({
							transition : "0ms linear",
							transform : "translate3d(" + aI.left + "px,"
									+ aI.top + "px,0)"
						})
					}
				}, 100)
			});
			ab.trigger("mousemove");
			var ay, az;
			aj(o, 1,
					function(aL, aI, aH) {
						var aK = Math.min(Math.max(ay + aI, ab.width()
								- aB.width()), 0), aJ = Math.min(Math.max(az
								+ aH, ab.height() - aB.height()), 0);
						if (I.support.transform && I.support.transition) {
							aB.css({
								transition : "0ms linear",
								transform : "translate3d(" + aK + "px, " + aJ
										+ "px,0)"
							})
						} else {
							aB.css("left", aK);
							aB.css("top", aJ)
						}
					}, function(aI) {
						if (!S(aI.target).parents(".ws_thumbs").get(0)) {
							return false
						}
						aE = 1;
						if (I.support.transform && I.support.transition) {
							var aH = l(aB);
							ay = aH.left;
							az = aH.top
						} else {
							ay = parseFloat(aB.css("left")) || 0;
							az = parseFloat(aB.css("top")) || 0
						}
						return true
					}, function() {
						aE = 0
					});
			o.find(".ws_thumbs a").each(function(aH, aI) {
				aj(aI, 0, 0, function(aJ) {
					return !!S(aJ.target).parents(".ws_thumbs").get(0)
				}, function(aJ) {
					aE = 1
				}, function(aJ) {
					ar(aJ, S(aI).index())
				})
			})
		}
		if (q.length) {
			var aG = q.find(">div");
			var aD = S("a", q);
			var av = aD.find("IMG");
			if (av.length) {
				var aw = S('<div class="ws_bulframe"/>').appendTo(aG);
				var f = S("<div/>").css({
					width : av.length + 1 + "00%"
				}).appendTo(S("<div/>").appendTo(aw));
				av.appendTo(f);
				S("<span/>").appendTo(aw);
				var c = -1;
				function aA(aJ) {
					if (aJ < 0) {
						aJ = 0
					}
					if (w) {
						w.loadTtip(aJ)
					}
					S(aD.get(c)).removeClass("ws_overbull");
					S(aD.get(aJ)).addClass("ws_overbull");
					aw.show();
					var aK = {
						left : aD.get(aJ).offsetLeft - aw.width() / 2,
						"margin-top" : aD.get(aJ).offsetTop
								- aD.get(0).offsetTop + "px",
						"margin-bottom" : -aD.get(aJ).offsetTop
								+ aD.get(aD.length - 1).offsetTop + "px"
					};
					var aI = av.get(aJ);
					var aH = {
						left : -aI.offsetLeft
								+ (S(aI).outerWidth(true) - S(aI).outerWidth())
								/ 2
					};
					if (c < 0) {
						aw.css(aK);
						f.css(aH)
					} else {
						if (!document.all) {
							aK.opacity = 1
						}
						aw.stop().animate(aK, "fast");
						f.stop().animate(aH, "fast")
					}
					c = aJ
				}
				aD.hover(function() {
					aA(S(this).index())
				});
				var aF;
				aG.hover(function() {
					if (aF) {
						clearTimeout(aF);
						aF = 0
					}
					aA(c)
				}, function() {
					aD.removeClass("ws_overbull");
					if (document.all) {
						if (!aF) {
							aF = setTimeout(function() {
								aw.hide();
								aF = 0
							}, 400)
						}
					} else {
						aw.stop().animate({
							opacity : 0
						}, {
							duration : "fast",
							complete : function() {
								aw.hide()
							}
						})
					}
				});
				aG.click(function(aH) {
					ar(aH, S(aH.target).index())
				})
			}
		}
	}
	function X(c) {
		S("A", ab)
				.each(
						function(ax) {
							if (ax == c) {
								var au = S(this);
								au.addClass("ws_selthumb");
								if (!U) {
									var f = ab.find(">div"), aw = au.position()
											|| {}, az;
									if (I.support.transform
											&& I.support.transition) {
										az = l(f);
										var ay = -Math.max(Math.min(aw.left,
												-az.left), aw.left + au.width()
												- ab.width()), av = -Math.max(
												Math.min(aw.top, 0), aw.top
														+ au.height()
														- ab.height());
										f.css({
											transition : "300ms ease",
											transform : "translate3d(" + ay
													+ "px," + av + "px,0)"
										})
									} else {
										az = f.position() || {};
										f
												.stop(true)
												.animate(
														{
															left : -Math
																	.max(
																			Math
																					.min(
																							aw.left,
																							-az.left),
																			aw.left
																					+ au
																							.width()
																					- ab
																							.width()),
															top : -Math
																	.max(
																			Math
																					.min(
																							aw.top,
																							0),
																			aw.top
																					+ au
																							.height()
																					- ab
																							.height())
														})
									}
								}
							} else {
								S(this).removeClass("ws_selthumb")
							}
						})
	}
	function ak(c) {
		S("A", q).each(function(f) {
			if (f == c) {
				S(this).addClass("ws_selbull")
			} else {
				S(this).removeClass("ws_selbull")
			}
		})
	}
	if (I.caption) {
		$caption = S("<div class='ws-title' style='display:none'></div>");
		o.append($caption);
		$caption.bind("mouseover", function(c) {
			t()
		});
		$caption.bind("mouseout", function(c) {
			Q()
		})
	}
	var G = function() {
		if (this.filters) {
			this.style.removeAttribute("filter")
		}
	};
	var ac = {
		none : function(f, c) {
			c.show()
		},
		fade : function(au, c, f) {
			c.fadeIn(f, G)
		},
		array : function(au, c, f) {
			r(c, au[Math.floor(Math.random() * au.length)], 0.5,
					"easeOutElastic1", f)
		},
		move : function(au, c, f) {
			ac.array([ {
				left1 : "100%",
				top2 : "100%"
			}, {
				left1 : "80%",
				left2 : "-50%"
			}, {
				top1 : "-100%",
				top2 : "100%",
				distance : 0.7,
				easing : "easeOutBack"
			}, {
				top1 : "-80%",
				top2 : "-80%",
				distance : 0.3,
				easing : "easeOutBack"
			}, {
				top1 : "-80%",
				left2 : "80%"
			}, {
				left1 : "80%",
				left2 : "80%"
			} ], c, f)
		},
		slide : function(au, c, f) {
			ag(c, {
				direction : "left",
				easing : "easeInOutExpo",
				complete : function() {
					if (c.get(0).filters) {
						c.get(0).style.removeAttribute("filter")
					}
				},
				duration : f
			})
		}
	};
	ac[0] = ac.slide;
	function J(f) {
		var av = S("img", f).attr("title");
		var au = S(f).data("descr");
		if (!av.replace(/\s+/g, "")) {
			av = ""
		}
		var c = S(".ws-title", o);
		c.stop(1, 1).stop(1, 1).fadeOut(
				I.captionDuration / 3,
				function() {
					if (av || au) {
						c.html((av ? "<span>" + av + "</span>" : "")
								+ (au ? "<div>" + au + "</div>" : ""));
						var aw = I.captionEffect;
						(ac[S.type(aw)] || ac[aw] || ac[0])(aw, c,
								I.captionDuration)
					}
				})
	}
	function Y(aw, f) {
		var ax, au = document.defaultView;
		if (au && au.getComputedStyle) {
			var av = au.getComputedStyle(aw, "");
			if (av) {
				ax = av.getPropertyValue(f)
			}
		} else {
			var c = f.replace(/\-\w/g, function(ay) {
				return ay.charAt(1).toUpperCase()
			});
			if (aw.currentStyle) {
				ax = aw.currentStyle[c]
			} else {
				ax = aw.style[c]
			}
		}
		return ax
	}
	function F(av, au, ay) {
		var ax = "padding-left|padding-right|border-left-width|border-right-width"
				.split("|");
		var aw = 0;
		for (var f = 0; f < ax.length; f++) {
			aw += parseFloat(Y(av, ax[f])) || 0
		}
		var c = parseFloat(Y(av, "width")) || ((av.offsetWidth || 0) - aw);
		if (au) {
			c += aw
		}
		if (ay) {
			c += (parseFloat(Y(av, "margin-left")) || 0)
					+ (parseFloat(Y(av, "margin-right")) || 0)
		}
		return c
	}
	function z(av, au, ay) {
		var ax = "padding-top|padding-bottom|border-top-width|border-bottom-width"
				.split("|");
		var aw = 0;
		for (var f = 0; f < ax.length; f++) {
			aw += parseFloat(Y(av, ax[f])) || 0
		}
		var c = parseFloat(Y(av, "height")) || ((av.offsetHeight || 0) - aw);
		if (au) {
			c += aw
		}
		if (ay) {
			c += (parseFloat(Y(av, "margin-top")) || 0)
					+ (parseFloat(Y(av, "margin-bottom")) || 0)
		}
		return c
	}
	function r(aw, aA, c, ay, au) {
		var av = aw.find(">span,>div").get();
		S(av).css({
			position : "relative",
			visibility : "hidden"
		});
		aw.show();
		for ( var f in aA) {
			if (/\%/.test(aA[f])) {
				aA[f] = parseInt(aA[f]) / 100;
				var az = aw.offset()[/left/.test(f) ? "left" : "top"];
				var aB = /left/.test(f) ? "width" : "height";
				if (aA[f] < 0) {
					aA[f] *= az
				} else {
					aA[f] *= o[aB]() - aw[aB]() - az
				}
			}
		}
		S(av[0]).css({
			left : (aA.left1 || 0) + "px",
			top : (aA.top1 || 0) + "px"
		});
		S(av[1]).css({
			left : (aA.left2 || 0) + "px",
			top : (aA.top2 || 0) + "px"
		});
		var au = aA.duration || au;
		function ax(aC) {
			var aD = S(av[aC]).css("opacity");
			S(av[aC]).css({
				visibility : "visible"
			}).css({
				opacity : 0
			}).animate({
				opacity : aD
			}, au, "easeOutCirc").animate({
				top : 0,
				left : 0
			}, {
				duration : au,
				easing : (aA.easing || ay),
				queue : false
			})
		}
		ax(0);
		setTimeout(function() {
			ax(1)
		}, au * (aA.distance || c))
	}
	function ag(az, aC) {
		var aB = {
			position : 0,
			top : 0,
			left : 0,
			bottom : 0,
			right : 0
		};
		for ( var au in aB) {
			aB[au] = az.get(0).style[au]
		}
		az.show();
		var ay = {
			width : F(az.get(0), 1, 1),
			height : z(az.get(0), 1, 1),
			"float" : az.css("float"),
			overflow : "hidden",
			opacity : 0
		};
		for ( var au in aB) {
			ay[au] = aB[au] || Y(az.get(0), au)
		}
		var f = S("<div></div>").css({
			fontSize : "100%",
			background : "transparent",
			border : "none",
			margin : 0,
			padding : 0
		});
		az.wrap(f);
		f = az.parent();
		if (az.css("position") == "static") {
			f.css({
				position : "relative"
			});
			az.css({
				position : "relative"
			})
		} else {
			S.extend(ay, {
				position : az.css("position"),
				zIndex : az.css("z-index")
			});
			az.css({
				position : "absolute",
				top : 0,
				left : 0,
				right : "auto",
				bottom : "auto"
			})
		}
		f.css(ay).show();
		var aA = aC.direction || "left";
		var av = (aA == "up" || aA == "down") ? "top" : "left";
		var aw = (aA == "up" || aA == "left");
		var c = aC.distance
				|| (av == "top" ? az.outerHeight(true) : az.outerWidth(true));
		az.css(av, aw ? (isNaN(c) ? "-" + c : -c) : c);
		var ax = {};
		ax[av] = (aw ? "+=" : "-=") + c;
		f.animate({
			opacity : 1
		}, {
			duration : aC.duration,
			easing : aC.easing
		});
		az.animate(ax, {
			queue : false,
			duration : aC.duration,
			easing : aC.easing,
			complete : function() {
				az.css(aB);
				az.parent().replaceWith(az);
				if (aC.complete) {
					aC.complete()
				}
			}
		})
	}
	if (q.length || ab.length) {
		g()
	}
	u(L);
	if (I.caption) {
		J(k[L])
	}
	if (I.stopOnHover) {
		this.bind("mouseover", function(c) {
			t();
			P = true
		});
		this.bind("mouseout", function(c) {
			Q();
			P = false
		})
	}
	Q(1);
	var R = o.find("audio").get(0), m = I.autoPlay;
	if (R) {
		if (window.Audio && R.canPlayType && R.canPlayType("audio/mp3")) {
			R.loop = "loop";
			if (I.autoPlay) {
				R.autoplay = "autoplay";
				setTimeout(function() {
					R.play()
				}, 100)
			}
		} else {
			R = R.src;
			var ae = R.substring(0, R.length - /[^\\\/]+$/.exec(R)[0].length);
			var p = "wsSound" + Math.round(Math.random() * 9999);
			S("<div>").appendTo(o).get(0).id = p;
			var v = "wsSL" + Math.round(Math.random() * 9999);
			window[v] = {
				onInit : function() {
				}
			};
			swfobject.createSWF({
				data : ae + "player_mp3_js.swf",
				width : "1",
				height : "1"
			}, {
				allowScriptAccess : "always",
				loop : true,
				FlashVars : "listener=" + v + "&loop=1&autoplay="
						+ (I.autoPlay ? 1 : 0) + "&mp3=" + R
			}, p);
			R = 0
		}
		o.bind("stop", function() {
			m = false;
			if (R) {
				R.pause()
			} else {
				S(p).SetVariable("method:pause", "")
			}
		});
		o.bind("start", function() {
			if (R) {
				R.play()
			} else {
				S(p).SetVariable("method:play", "")
			}
		})
	}
	j.wsStart = n;
	j.wsStop = B;
	if (I.playPause) {
		var i = S('<a href="#" class="ws_playpause"></a>');
		if (I.autoPlay) {
			i.addClass("ws_pause")
		} else {
			i.addClass("ws_play")
		}
		i.click(function() {
			I.autoPlay = !I.autoPlay;
			if (!I.autoPlay) {
				j.wsStop();
				i.removeClass("ws_pause");
				i.addClass("ws_play")
			} else {
				Q();
				i.removeClass("ws_play");
				i.addClass("ws_pause")
			}
			return false
		});
		this.append(i)
	}
	function y() {
		o.css("fontSize", Math.max(
				Math.min((o.width() / I.width) || 1, 1) * 10, 6))
	}
	if (I.responsive) {
		S(y);
		S(window).on("load resize", y)
	}
	return this
};
jQuery.extend(jQuery.easing, {
	easeInOutExpo : function(e, f, a, h, g) {
		if (f == 0) {
			return a
		}
		if (f == g) {
			return a + h
		}
		if ((f /= g / 2) < 1) {
			return h / 2 * Math.pow(2, 10 * (f - 1)) + a
		}
		return h / 2 * (-Math.pow(2, -10 * --f) + 2) + a
	},
	easeOutCirc : function(e, f, a, h, g) {
		return h * Math.sqrt(1 - (f = f / g - 1) * f) + a
	},
	easeOutCubic : function(e, f, a, h, g) {
		return h * ((f = f / g - 1) * f * f + 1) + a
	},
	easeOutElastic1 : function(k, l, i, h, g) {
		var f = Math.PI / 2;
		var m = 1.70158;
		var e = 0;
		var j = h;
		if (l == 0) {
			return i
		}
		if ((l /= g) == 1) {
			return i + h
		}
		if (!e) {
			e = g * 0.3
		}
		if (j < Math.abs(h)) {
			j = h;
			var m = e / 4
		} else {
			var m = e / f * Math.asin(h / j)
		}
		return j * Math.pow(2, -10 * l) * Math.sin((l * g - m) * f / e) + h + i
	},
	easeOutBack : function(e, f, a, i, h, g) {
		if (g == undefined) {
			g = 1.70158
		}
		return i * ((f = f / h - 1) * f * ((g + 1) * f + g) + 1) + a
	}
});
jQuery.fn.wowSlider.support = {
	transform : (function() {
		var b = "transform WebkitTransform MozTransform OTransform MsTransform"
				.split(" ");
		for (var a = 0; a < b.length; a++) {
			if (document.body.style[b[a]] !== undefined) {
				return !!b[a]
			}
		}
		return false
	})(),
	perspective : (function() {
		var b = "perspectiveProperty perspective WebkitPerspective MozPerspective OPerspective MsPerspective"
				.split(" ");
		for (var a = 0; a < b.length; a++) {
			if (document.body.style[b[a]] !== undefined) {
				return !!b[a]
			}
		}
		return false
	})(),
	transition : (function() {
		var a = document.body || document.documentElement, b = a.style;
		return b.transition !== undefined || b.WebkitTransition !== undefined
				|| b.MozTransition !== undefined
				|| b.MsTransition !== undefined || b.OTransition !== undefined
	})()
};// -----------------------------------------------------------------------------------
// http://wowslider.com/
// JavaScript Wow Slider is a free software that helps you easily generate
// delicious
// slideshows with gorgeous transition effects, in a few clicks without writing
// a single line of code.
// Generated by $AppName$ $AppVersion$
//
// ***********************************************
// Obfuscated by Javascript Obfuscator
// http://javascript-source.com
// ***********************************************
function wowsliderPreloader(m, d) {
	var f = jQuery, j = d.images, n = [], q = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7";
	function h(t, u) {
		var i = new Image();
		if (u) {
			f(i).bind("load error abort", function(v) {
				if (v.type == "load") {
					u(t, i)
				}
			})
		} else {
			n[n.length] = i
		}
		i.src = t;
		return i
	}
	h(q);
	var p = 0;
	function b(i, t) {
		i = (j.length + i) % j.length;
		if (!j[i]["noimage"]) {
			if (t) {
				t();
				b(i < p ? i - 1 : i + 1);
				p = i
			}
			return 0
		} else {
			h(j[i].src, function(u) {
				j[i].image.src = u;
				j[i].noimage = 0;
				if (t) {
					setTimeout(t, 40);
					b(i < p ? i - 1 : i + 1);
					p = i
				}
			});
			return 1
		}
	}
	var r = f(" .ws_images ul", m);
	var g = r.find("li").length;
	var a = r.find("img").get(0).src;
	for (var o = 0; o < j.length; o++) {
		if (j[o]) {
			if (o >= g) {
				var c = f(
						"<li>"
								+ (j[o].href ? '<a href="'
										+ j[o].href
										+ '"'
										+ (j[o].target ? ' target="'
												+ j[o].target + '"' : "") + ">"
										: "") + '<img src="' + a + '"/>'
								+ (j[o].href ? "</a>" : "") + "</li>")
						.appendTo(r);
				f("img", c).attr("title", j[o].title);
				c.data("descr", j[o].descr || "");
				j[o].image = f("img", c).get(0);
				j[o].noimage = 1;
				if (/^\./.test(j[o].src)) {
					j[o].src = a.substr(0, a.lastIndexOf("/"))
							+ j[o].src.substr(1)
				}
			}
		}
	}
	r.css({
		width : j.length + "00%"
	});
	var k = f(" .ws_bullets>div", m);
	if (f("img", k).length) {
		var a = k.find("img").get(0).src;
		k.find(">a").each(
				function(u, t) {
					if (j[u]) {
						t.href = "#";
						if (!j[u].thumb) {
							j[u].thumb = j[u].src.replace(
									/\/images\/([^\/]+)$/, "/tooltips/$1")
						}
						if (/^\./.test(j[u].thumb)) {
							j[u].thumb = a.substr(0, a.lastIndexOf("/"))
									+ j[u].thumb.substr(1)
						}
						if (!f("img", t).length) {
							j[u].nottip = 1;
							j[u].ttip = f(
									'<img class="loading" src="' + q + '"/>')
									.appendTo(t).get(0)
						}
					}
				})
	}
	h(a, function() {
		b(1)
	});
	this.loadTtip = function(i) {
		if (j[i].nottip) {
			h(j[i].thumb, function(u) {
				var t = j[i];
				t.ttip.src = u;
				t.nottip = 0;
				f(t.ttip).removeClass("loading")
			})
		}
	};
	var e = f("<div class='ws_logo'></div>").hide().appendTo(m);
	var s;
	var l;
	this.load = function(i, t) {
		l = t;
		if (!b(i, function() {
			if (l == t) {
				clearTimeout(s);
				s = 0;
				e.hide();
				t()
			}
		})) {
			return
		}
		if (!s) {
			s = setTimeout(function() {
				e.show()
			}, 300)
		}
	}
};