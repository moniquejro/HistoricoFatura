function openLancamentos(IdLancamento, CategoriaLancamento, DataLancamento, ValorLancamento) {
  // ocultar os elementos class="tabcontent" por default */
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }

  // remover a cor de fundo dos btn
  tablinks = document.getElementsByClassName("item-processo");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].style.backgroundColor = "";
  }

  // mostrar conteúdo da guia especifica
  document.getElementById(IdLancamento).style.display = "block";
}

var soma = openLancamentos.ValorLancamento()
print(openLancamentos);

// obter elemento com id="defaulOpen" e clicar
document.getElementById("defaultOpen").click();

var relatorios = [];

    $.ajax({
        url: '<c:url value="/getLancamento"/>',
        type: 'GET',
        success: function(data) {
            for(var i = 0; i < data.length; i++){
                relatorios.push(data[i]);
            }
        }
    });

