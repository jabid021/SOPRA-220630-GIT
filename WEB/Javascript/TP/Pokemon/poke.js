


//1) saisir le nom du pokemon et valider avec le bouton
    //inputName.value
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

  var posX=0;
  var posY=0;

  var img="pikachuDown";



  btnStart.onclick=lancerAventure;

  function lancerAventure()
  {
    if(inputName.value!="")
    {
      formStart.style.display="none";
      grass.style.display="block";
      pikachu.setAttribute("title",inputName.value);
      document.body.onkeyup=deplacement;
    }
    else
    {
      error.innerHTML="Il faut saisir un nom !";
    }
  }

  function deplacement(event)
  {
    if(event.key=="ArrowUp" || event.key=="z")
    {
      if(posY>=30)
      {
        posY-=30;
      }
      if(posY>=15 && event.ctrlKey)
      {
        posY-=15;
      }
      img="pikachuDown";
    }

    else if(event.key=="ArrowDown" || event.key=="s")
    {
      if(posY<=630)
      {
        posY+=30;
      }
      if(posY<=645 && event.ctrlKey)
      {
        posY+=15;
      }
      img="pikachuUp";
    }

    else  if(event.key=="ArrowLeft" || event.key=="q")
    {
      if(posX>=30)
      {
        posX-=30;
        img="pikachuRight";
      }
      if(posX>=15 && event.ctrlKey)
      {
        posX-=15;
      }
    }

    else  if(event.key=="ArrowRight"|| event.key=="d")
    {
      if(posX<=630)
      {
        posX+=30;
      }
      if(posX<=645 && event.ctrlKey)
      {
        posX+=15;
      }
      img="pikachuLeft";
    }




    pikachu.style.top=posY+"px";
    pikachu.style.left=posX+"px";
    imgPikachu.setAttribute("src","assets/img/"+img+".png");

  }
