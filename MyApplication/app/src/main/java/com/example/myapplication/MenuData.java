package com.example.myapplication;

public class MenuData {
    private String name;
    private String ingredient;

    public MenuData(String name, String ingredient){
        this.name = name;
        this.ingredient = ingredient;
    }

    public String getName(){
        return this.name;
    }
    public String ingredient(){
        String str = "";

        if(this.ingredient.charAt(1)=='1'){  str += "메밀";
            if(this.ingredient.charAt(0)=='1'){   str += "(뺄 수 있음)";   }
            str += ",  ";
        }
        if(this.ingredient.charAt(3)=='1'){  str += "밀";
            if(this.ingredient.charAt(2)=='1'){    str += "(뺄 수 있음)";   }
            str += ",  ";
        }
        if(this.ingredient.charAt(5)=='1'){   str += "콩";
            if(this.ingredient.charAt(4)=='1'){   str += "(뺄 수 있음)";    }
            str += ",  ";
        }
        if(this.ingredient.charAt(7)=='1'){    str += "호두";
            if(this.ingredient.charAt(6)=='1'){    str += "(뺄 수 있음)";    }
            str += ",  ";
        }
        if(this.ingredient.charAt(9)=='1'){    str += "땅콩";
            if(this.ingredient.charAt(8)=='1'){     str += "(뺄 수 있음)";    }
            str += ",  ";
        }
        if(this.ingredient.charAt(11)=='1'){    str += "복숭아";
            if(this.ingredient.charAt(10)=='1'){   str += "(뺄 수 있음)";    }
            str += ",  ";
        }
        if(this.ingredient.charAt(13)=='1'){    str += "토마토";
            if(this.ingredient.charAt(12)=='1'){       str += "(뺄 수 있음)";     }
            str += ",  ";
        }
        if(this.ingredient.charAt(15)=='1'){   str += "돼지";
            if(this.ingredient.charAt(14)=='1'){     str += "(뺄 수 있음)";     }
            str += ",  ";
        }
        if(this.ingredient.charAt(17)=='1'){      str += "가금류";
            if(this.ingredient.charAt(16)=='1'){       str += "(뺄 수 있음)";    }
            str += ",  ";
        }
        if(this.ingredient.charAt(19)=='1'){     str += "우유";
            if(this.ingredient.charAt(18)=='1'){       str += "(뺄 수 있음)";  }
            str += ",  ";
        }
        if(this.ingredient.charAt(21)=='1'){    str += "닭";
            if(this.ingredient.charAt(20)=='1'){     str += "(뺄 수 있음)";    }
            str += ",  ";
        }
        if(this.ingredient.charAt(23)=='1'){     str += "소";
            if(this.ingredient.charAt(22)=='1'){      str += "(뺄 수 있음)";    }
            str += ",  ";
        }
        if(this.ingredient.charAt(25)=='1'){       str += "새우";
            if(this.ingredient.charAt(24)=='1'){       str += "(뺄 수 있음)";   }
            str += ",  ";
        }
        if(this.ingredient.charAt(27)=='1'){    str += "고등어";
            if(this.ingredient.charAt(26)=='1'){       str += "(뺄 수 있음)";   }
            str += ",  ";
        }
        if(this.ingredient.charAt(29)=='1'){     str += "홍합";
            if(this.ingredient.charAt(28)=='1'){         str += "(뺄 수 있음)";    }
            str += ",  ";
        }
        if(this.ingredient.charAt(31)=='1'){    str += "전복";
            if(this.ingredient.charAt(30)=='1'){        str += "(뺄 수 있음)";    }
            str += ",  ";
        }
        if(this.ingredient.charAt(33)=='1'){     str += "굴";
            if(this.ingredient.charAt(32)=='1'){       str += "(뺄 수 있음)";      }
            str += ",  ";
        }
        if(this.ingredient.charAt(35)=='1'){     str += "조개";
            if(this.ingredient.charAt(34)=='1'){        str += "(뺄 수 있음)";     }
            str += ",  ";
        }
        if(this.ingredient.charAt(37)=='1'){    str += "게";
            if(this.ingredient.charAt(36)=='1'){        str += "(뺄 수 있음)";    }
            str += ",  ";
        }
        if(this.ingredient.charAt(39)=='1'){     str += "오징어";
            if(this.ingredient.charAt(38)=='1'){        str += "(뺄 수 있음)";    }
            str += ",  ";
        }
        if(this.ingredient.charAt(41)=='1'){    str += "오이";
            if(this.ingredient.charAt(40)=='1'){       str += "(뺄 수 있음)";      }
            str += ",  ";
        }
        if(this.ingredient.charAt(43)=='1'){     str += "양파";
            if(this.ingredient.charAt(42)=='1'){        str += "(뺄 수 있음)";     }
            str += ",  ";
        }
        if(this.ingredient.charAt(45)=='1'){     str += "당근";
            if(this.ingredient.charAt(44)=='1'){        str += "(뺄 수 있음)"; }
            str += ",  ";
        }
        if(this.ingredient.charAt(47)=='1'){  str += "가지";
            if(this.ingredient.charAt(46)=='1'){      str += "(뺄 수 있음)";    }
            str += ",  ";
        }
        if(this.ingredient.charAt(49)=='1'){    str += "브로콜리";
            if(this.ingredient.charAt(48)=='1'){      str += "(뺄 수 있음)";   }
            str += ",  ";
        }
        if(this.ingredient.charAt(51)=='1'){    str += "해초류";
            if(this.ingredient.charAt(50)=='1'){       str += "(뺄 수 있음)";    }
            str += ",  ";
        }
        if(this.ingredient.charAt(53)=='1'){     str += "버섯";
            if(this.ingredient.charAt(52)=='1'){       str += "(뺄 수 있음)";    }
            str += ",  ";
        }
        if(this.ingredient.charAt(55)=='1'){     str += "고수";
            if(this.ingredient.charAt(54)=='1'){       str += "(뺄 수 있음)";     }
            str += ",  ";
        }




        return str;
    }
}
