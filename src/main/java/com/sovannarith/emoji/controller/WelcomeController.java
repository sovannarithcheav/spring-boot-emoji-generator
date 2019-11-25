package com.sovannarith.emoji.controller;

import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @GetMapping({"/", "/index"})
    public String main() {
        return "index"; //view
    }

    @RequestMapping("/lele")
    public @ResponseBody
    String getEmoji(){
        String str = "An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!";
        StringBuilder result = new StringBuilder(EmojiParser.parseToUnicode(str));
        for (Emoji emoji : EmojiManager.getAll()) {
            result.append(emoji.getUnicode());
        }
        System.out.println(result);
        return "\uD83D\uDE00" + result;
    }

}