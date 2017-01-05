</main>
    </div>

    <script>
    	$('.mdl-menu__item.link').click(function(e) {
    		e.preventDefault();
    		var href = $(this).data('href');
    		window.location.href = href;
    	});
    </script>
  </body>
</html>
