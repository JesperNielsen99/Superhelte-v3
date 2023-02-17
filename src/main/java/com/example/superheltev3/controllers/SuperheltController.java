package com.example.superheltev3.controllers;

import com.example.superheltev3.models.Superhelt;
import com.example.superheltev3.services.SuperheltService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="superhelte")
public class SuperheltController {
    private SuperheltService superheltService;

    public SuperheltController(SuperheltService superheltService) {
        this.superheltService = superheltService;
    }

    @RequestMapping(path="")
    public ResponseEntity<?> seAlleHelte(@RequestParam (required = false) String format) {
        if (format != null && format.equals("html")) {
            List<Superhelt> superheltList = superheltService.getHelte();
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Content-Type", "text/html");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<html><body><table>");
            stringBuilder.append("<tr>" +
                            "<th> Hero Name </th>\n" +
                            "<th> Private Name </th>\n" +
                            "</tr>");
            for (Superhelt superhelt : superheltList) {
                stringBuilder.append("<tr>");
                stringBuilder.append("<td>" + superhelt.getHeroName() + "</td>");
                stringBuilder.append("<td>" + superhelt.getPrivateName() + "</td>");
                stringBuilder.append("</tr>");
            }
            stringBuilder.append("</html></body></table>");

            return new ResponseEntity<>(stringBuilder.toString(),
                    responseHeaders, HttpStatus.OK);
        } else {
            List<Superhelt> superheltList = superheltService.getHelte();
            StringBuilder stringBuilder = new StringBuilder();
            for (Superhelt superhelt : superheltList) {
                stringBuilder.append("Hero Name: " + superhelt.getHeroName()).append("\n");
                stringBuilder.append("Private Name: " + superhelt.getPrivateName()).append("\n");
            }
            return new ResponseEntity<>(stringBuilder, HttpStatus.OK);
        }
    }

    @GetMapping(path="{navn}")
    public ResponseEntity<Superhelt> hentSuperhelt(@PathVariable String navn) {
        return new ResponseEntity<Superhelt>(superheltService.searchHeroName(navn), HttpStatus.OK);
    }

    @PostMapping(path="opret")
    public ResponseEntity<Superhelt> opretSuperhelt(@RequestBody Superhelt superhelt) {
        return new ResponseEntity<Superhelt>(superheltService.addSuperhero(superhelt), HttpStatus.OK);
    }

    @PutMapping(path="ret")
    public ResponseEntity<Superhelt> retSuperhelt(@RequestBody Superhelt superhelt) {
        return new ResponseEntity<Superhelt>(superheltService.editSuperhero(superhelt), HttpStatus.OK);
    }

    @DeleteMapping(path="slet")
    public ResponseEntity<Superhelt> sletSuperhelt(@RequestBody String navn) {
        return new ResponseEntity<Superhelt>(superheltService.deleteSuperhero(navn), HttpStatus.OK);
    }
}
