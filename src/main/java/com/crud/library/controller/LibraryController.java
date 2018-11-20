package com.crud.library.controller;
import com.crud.library.Dto.BookDto;
import com.crud.library.Dto.SpecimenDto;
import com.crud.library.Dto.UserDto;
import com.crud.library.domain.Specimen;
import com.crud.library.mapper.BookMapper;
import com.crud.library.mapper.SpecimenMapper;
import com.crud.library.mapper.UserMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/library")
public class LibraryController {
    @Autowired
    private DbService service;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private SpecimenMapper specimenMapper;


    @RequestMapping(method = RequestMethod.POST,value = "createUser",consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        service.saveUser(userMapper.mapToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.POST,value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto){
        service.saveBook(bookMapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.POST,value = "createSpecimen",consumes = APPLICATION_JSON_VALUE)
    public void createSpecimen(@RequestBody SpecimenDto specimenDto) {
        service.saveSpecimen(specimenMapper.mapToSpecimen(specimenDto));
    }

    @RequestMapping(method = RequestMethod.PUT,value = "updateSpecimen")
    public SpecimenDto updateSpecimen(@RequestBody SpecimenDto specimenDto) {
        return specimenMapper.mapToSpecimenDto(service.saveSpecimen(specimenMapper.mapToSpecimen(specimenDto)));
    }

    @RequestMapping(method = RequestMethod.GET,value = "getSpecimenByTitleId")
    public List<SpecimenDto> getSpecimenByTitleId(@RequestParam Long titleId) throws SpecimenNotFoundException{
        List<Specimen> specimenList = service.getSpecimenListById(titleId);
        if (specimenList.size() == 0) {
            throw new SpecimenNotFoundException();
        }
        return specimenMapper.mapToSpecimenDtoList(specimenList);
    }

    @PostMapping(value = "borrowBook")
    public boolean borrowBook(@RequestParam("userId") Long userId,@RequestParam("specimenId")Long specimenId) {
        return service.borrowBook(userId,specimenId);
    }
    @PostMapping(value = "returnBook")
    public boolean returnBook(@RequestParam("specimenId")Long specimenId) {
        return service.returnBook(specimenId);
    }

}
