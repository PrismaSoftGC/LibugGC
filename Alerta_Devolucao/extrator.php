<?php
$conexao = new mysqli('localhost','root','','biblioteca');

date_default_timezone_set('America/Sao_Paulo');
$date = date('Y-m-d');
$dataVerificacao = date('Y-m-d', strtotime(' + 1 days'));
echo "Data atual: ";
echo $date;

echo ("<br/>");
echo ("-------------------------------------------------------------------------------------------------------------------------");

$emails = $conexao->query("SELECT nome, email, devolucao FROM cliente INNER join emprestimo on cliente.codigoCliente = emprestimo.codigoCliente AND emprestimo.devolucao = '$dataVerificacao'");

while($aux=$emails->fetch_array() ){
	
	echo ("<br/>");
	
	$email = $aux['email'];
	$nome = $aux['nome'];

	echo ("Nome: ");
	echo $nome;
	echo ("<br/>");
	echo ("E-mail: ");
	echo $email;
	echo ("<br/>");

	//variaveis locais recebendo os valores do banco 
	$email = "$email";
	$nome = "$nome";
	$devolucao = date('d/m/Y', strtotime(' + 1 days'));

	
	$para = "to:$email";
	$assunto = "PrismaSoft - Alerta de Devolução";
	$mensagem = "Olá, $nome voce tem devolução que vence amanha dia $devolucao, evite pagar multas e faça a devolução.";
	$cabecalho = "MIME-Version: 1.0" . "\r\n";
	$cabecalho .= "Content-type: text/html; charset=ISO 8859-1" . "\r\n";
	$cabecalho .= "from: prismasoftgc<prismasoftgc@gmail.com>" . "\r\n" . "Reply-to: $email" . "\r\n";

	mail($para, $assunto, $mensagem, $cabecalho);
	echo "Email enviado com sucesso.";
	echo ("<br/>");
	echo ("-------------------------------------------------------------------------------------------------------------------------");
}
?>
